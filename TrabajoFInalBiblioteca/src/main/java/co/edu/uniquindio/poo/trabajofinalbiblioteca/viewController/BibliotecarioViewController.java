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

    private BibliotecarioController controller;

    @FXML
    private Button btnVolver;

    @FXML
    private Button agregarPersonaBtn;


    /**
     * Este método es llamado automáticamente por JavaFX al cargar la vista.
     */
    @FXML
    public void initialize() {

        // Recuperar bibliotecario que inició sesión (solo si ya está cargado en App.biblioteca)
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
    }

    private void agregarPersona() {
        String nombre = txtNombrePersona.getText().trim();
        String id = txtIdPersona.getText().trim();

        if (nombre.isEmpty() || id.isEmpty()) {
            mostrarMensaje("Debe llenar todos los campos para agregar una persona.");
            return;
        }

        Persona nuevaPersona = new Visitante(nombre, id); // Por defecto se agrega como Visitante
        controller.agregarPersona(nuevaPersona);
        mostrarMensaje("Persona agregada correctamente.");
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
