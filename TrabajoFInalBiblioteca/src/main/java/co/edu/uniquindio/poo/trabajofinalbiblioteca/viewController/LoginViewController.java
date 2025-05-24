package co.edu.uniquindio.poo.trabajofinalbiblioteca.viewController;

import co.edu.uniquindio.poo.trabajofinalbiblioteca.Model.Empleado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class LoginViewController {

    @FXML
    private TextField usuarioField;

    @FXML
    private PasswordField contraseniaField;

    @FXML
    private ChoiceBox<String> rolChoiceBox;

    @FXML
    private Button ingresarBtn;

    private List<Empleado> listaEmpleados;

    public void setListaEmpleados(List<Empleado> empleados) {
        this.listaEmpleados = empleados;
    }

    @FXML
    public void initialize() {
        rolChoiceBox.getItems().addAll("Administrador", "Bibliotecario");
    }

    @FXML
    public void ingresar(ActionEvent event) throws IOException {
        String usuario = usuarioField.getText();
        String contrasenia = contraseniaField.getText();
        String rolSeleccionado = rolChoiceBox.getValue();

        if (rolSeleccionado == null || usuario.isEmpty() || contrasenia.isEmpty()) {
            mostrarAlerta("Error", "Todos los campos son obligatorios.");
            return;
        }

        for (Empleado empleado : listaEmpleados) {
            if (empleado.getClass().getSimpleName().equalsIgnoreCase(rolSeleccionado)
                    && empleado.validarCredenciales(usuario, contrasenia)) {

                FXMLLoader loader = new FXMLLoader(getClass().getResource(
                        rolSeleccionado.equals("Administrador") ? "/views/AdministradorView.fxml" : "/views/BibliotecarioView.fxml"
                ));
                Stage stage = (Stage) ingresarBtn.getScene().getWindow();
                Scene nuevaEscena = new Scene(loader.load());
                stage.setScene(nuevaEscena);
                stage.show();
                return;
            }
        }

        mostrarAlerta("Error", "Credenciales incorrectas o rol no válido.");
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}