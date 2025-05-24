package co.edu.uniquindio.poo.trabajofinalbiblioteca.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;

import java.io.IOException;

public class SeleccionRolViewController {

    @FXML
    private void seleccionarAdministrador(ActionEvent event) {
        abrirVentanaLogin(event, "Administrador");
    }

    @FXML
    private void seleccionarBibliotecario(ActionEvent event) {
        abrirVentanaLogin(event, "Bibliotecario");
    }

    @FXML
    private void seleccionarUsuario(ActionEvent event) {
        abrirVentanaLogin(event, "Usuario");
    }

    private void abrirVentanaLogin(ActionEvent event, String rol) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/trabajofinalbiblioteca/View/LoginView.fxml"));
            Parent root = loader.load();

            // Si quieres pasar el rol al LoginController, puedes hacer esto:
            /*
            LoginViewController controller = loader.getController();
            controller.setRolSeleccionado(rol);
            */

            Stage stage = new Stage();
            stage.setTitle("Iniciar Sesión - " + rol);
            stage.setScene(new Scene(root));
            stage.show();

            // Cerrar la ventana actual
            ((Stage)((Node)event.getSource()).getScene().getWindow()).close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
