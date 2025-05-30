package co.edu.uniquindio.poo.trabajofinalbiblioteca.viewController;


import co.edu.uniquindio.poo.trabajofinalbiblioteca.App;
import co.edu.uniquindio.poo.trabajofinalbiblioteca.Model.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class AdministradorViewController {

    @FXML
    private TextArea reporteTextArea;
    @FXML
    private TextField nombreField, idField, correoField;
    @FXML
    private ListView<Empleado> empleadosListView;
    @FXML
    private ComboBox<Bibliotecario> bibliotecarioComboBox;
    @FXML
    private Button btnVolver;

    private Administrador administrador;

    public void initialize() {
        administrador = (Administrador) App.biblioteca.getListEmpleados().stream()
                .filter(e -> e instanceof Administrador)
                .findFirst()
                .orElse(null);

        empleadosListView.getItems().addAll(App.biblioteca.getListEmpleados());
        for (Empleado e : App.biblioteca.getListEmpleados()) {
            if (e instanceof Bibliotecario) {
                bibliotecarioComboBox.getItems().add((Bibliotecario) e);
            }
        }
    }

    @FXML
    public void generarReporte() {
        Bibliotecario seleccionado = bibliotecarioComboBox.getValue();
        if (seleccionado != null) {
            String reporte = administrador.generarReporte(seleccionado);
            reporteTextArea.setText(reporte);
        }
    }
    @FXML
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
    private void mostrarMensaje(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Información");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    @FXML
    public void agregarEmpleado() {
        Empleado nuevo = new Bibliotecario(
                nombreField.getText(),
                idField.getText(),
                correoField.getText(),
                "usuario", "contrasena"
        );
        administrador.agregarEmpleado(App.biblioteca, nuevo);
        empleadosListView.getItems().add(nuevo);
        limpiarCampos();
    }

    @FXML
    public void actualizarEmpleado() {
        Empleado seleccionado = empleadosListView.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            administrador.actualizarEmpleado(App.biblioteca, seleccionado,
                    nombreField.getText(), idField.getText(), correoField.getText());
            empleadosListView.refresh();
            limpiarCampos();
        }
    }

    @FXML
    public void eliminarEmpleado() {
        Empleado seleccionado = empleadosListView.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            administrador.eliminarEmpleado(App.biblioteca, seleccionado);
            empleadosListView.getItems().remove(seleccionado);
            limpiarCampos();
        }
    }

    @FXML
    public void visualizarEmpleado() {
        Empleado seleccionado = empleadosListView.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            nombreField.setText(seleccionado.getNombre());
            idField.setText(seleccionado.getId());
            correoField.setText(seleccionado.getCorreo());
        }
    }

    public void limpiarCampos() {
        nombreField.clear();
        idField.clear();
        correoField.clear();
    }
}
