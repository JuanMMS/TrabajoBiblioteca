package co.edu.uniquindio.poo.trabajofinalbiblioteca.viewController;

import co.edu.uniquindio.poo.trabajofinalbiblioteca.Model.Empleado;
import co.edu.uniquindio.poo.trabajofinalbiblioteca.controller.LoginController;
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
    private RadioButton adminRadioBtn;

    @FXML
    private RadioButton bibliotecarioRadioBtn;

    @FXML
    private ToggleGroup rolGroup;

    @FXML
    private Button ingresarBtn;

    private List<Empleado> listaEmpleados;

    private final LoginController loginController = new LoginController();

    public void setListaEmpleados(List<Empleado> empleados) {
        this.listaEmpleados = empleados;
        loginController.setListaEmpleados(empleados);
    }

    @FXML
    public void initialize() {
        if (rolGroup == null) {
            rolGroup = new ToggleGroup();
            adminRadioBtn.setToggleGroup(rolGroup);
            bibliotecarioRadioBtn.setToggleGroup(rolGroup);
        }
    }

    @FXML
    public void ingresar(ActionEvent event) throws IOException {
        String usuario = usuarioField.getText();
        String contrasenia = contraseniaField.getText();

        String rolSeleccionado = null;
        if (adminRadioBtn.isSelected()) {
            rolSeleccionado = "Administrador";
        } else if (bibliotecarioRadioBtn.isSelected()) {
            rolSeleccionado = "Bibliotecario";
        }

        if (rolSeleccionado == null || usuario.isEmpty() || contrasenia.isEmpty()) {
            mostrarAlerta("Error", "Todos los campos son obligatorios y debe seleccionar un rol.");
            return;
        }

        Empleado empleado = loginController.autenticar(usuario, contrasenia, rolSeleccionado);
        if (empleado != null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    rolSeleccionado.equals("Administrador")
                            ? "/co/edu/uniquindio/poo/trabajofinalbiblioteca/administrador_view.fxml"
                            : "/co/edu/uniquindio/poo/trabajofinalbiblioteca/bibliotecario_view.fxml"
            ));
            Stage stage = (Stage) ingresarBtn.getScene().getWindow();
            Scene nuevaEscena = new Scene(loader.load());
            stage.setScene(nuevaEscena);
            stage.show();
        } else {
            mostrarAlerta("Error", "Credenciales incorrectas o rol no válido.");
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}