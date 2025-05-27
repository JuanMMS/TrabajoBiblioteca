package co.edu.uniquindio.poo.trabajofinalbiblioteca.viewController;

import co.edu.uniquindio.poo.trabajofinalbiblioteca.App;
import co.edu.uniquindio.poo.trabajofinalbiblioteca.Model.*;
import co.edu.uniquindio.poo.trabajofinalbiblioteca.controller.BibliotecarioController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class BibliotecarioViewController {

    @FXML
    private TextField txtNombrePersona;

    @FXML
    private TextField txtIdPersona;

    @FXML
    private Button btnAgregarPersona;

    @FXML
    private Button btnGenerarReporte;

    @FXML
    private TextArea txtAreaReporte;

    @FXML
    private Button btnVolver;

    @FXML
    private Button agregarPersonaBtn;

    @FXML
    private Button btnActualizarPersona;

    @FXML
    private Button btnEliminarPersona;

    @FXML
    private ComboBox<String> comboTipoPersona;

    private BibliotecarioController controller;

    @FXML
    public void initialize() {
        Bibliotecario bibliotecario = obtenerBibliotecarioLogueado();

        if (bibliotecario != null) {
            this.controller = new BibliotecarioController(bibliotecario);
            inicializarEventos();
        } else {
            mostrarMensaje("Error: No se pudo obtener el bibliotecario.");
        }
    }

    private void inicializarEventos() {
        btnVolver.setOnAction(e -> volver());
        btnAgregarPersona.setOnAction(e -> agregarPersona());
        btnGenerarReporte.setOnAction(e -> generarReporte());
        btnActualizarPersona.setOnAction(e -> actualizarPersona());
        btnEliminarPersona.setOnAction(e -> eliminarPersona());
    }

    private void agregarPersona() {
        String nombre = txtNombrePersona.getText().trim();
        String id = txtIdPersona.getText().trim();
        String tipo = comboTipoPersona.getValue();

        if (nombre.isEmpty() || id.isEmpty() || tipo == null) {
            mostrarMensaje("Debe llenar todos los campos para agregar una persona.");
            return;
        }

        Persona nuevaPersona = switch (tipo) {
            case "Estudiante" -> new Estudiante(nombre, id);
            case "Docente" -> new Docente(nombre, id);
            default -> new Visitante(nombre, id);
        };

        controller.agregarPersona(nuevaPersona);
        mostrarMensaje("Persona agregada correctamente.");
        limpiarCampos();
    }

    private void actualizarPersona() {
        String nombre = txtNombrePersona.getText().trim();
        String id = txtIdPersona.getText().trim();

        Persona persona = App.biblioteca.buscarPersonaPorId(id);

        if (persona == null) {
            mostrarMensaje("No se encontró la persona con ID: " + id);
            return;
        }

        controller.actualizarPersona(persona, nombre, id);
        mostrarMensaje("Persona actualizada correctamente.");
    }

    private void eliminarPersona() {
        String id = txtIdPersona.getText().trim();
        Persona persona = App.biblioteca.buscarPersonaPorId(id);

        if (persona == null) {
            mostrarMensaje("No se encontró la persona con ID: " + id);
            return;
        }

        controller.eliminarPersona(persona);
        mostrarMensaje("Persona eliminada correctamente.");
        limpiarCampos();
    }

    private void generarReporte() {
        String reporte = controller.generarReporte();
        txtAreaReporte.setText(reporte);
    }

    private Bibliotecario obtenerBibliotecarioLogueado() {
        for (Empleado empleado : App.biblioteca.getListEmpleados()) {
            if (empleado instanceof Bibliotecario) {
                return (Bibliotecario) empleado;
            }
        }
        return null;
    }

    private void volver() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/trabajofinalbiblioteca/Primary.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) btnVolver.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            mostrarMensaje("Error al volver: " + e.getMessage());
        }
    }

    private void limpiarCampos() {
        txtNombrePersona.clear();
        txtIdPersona.clear();
        comboTipoPersona.getSelectionModel().clearSelection();
    }

    private void mostrarMensaje(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Información");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    public void setController(BibliotecarioController controller) {
        this.controller = controller;
    }

    public void abrirRegistroPrestamo(javafx.event.ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/trabajofinalbiblioteca/prestamo-view.fxml"));
            Scene nuevaEscena = new Scene(loader.load());

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(nuevaEscena);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
