package co.edu.uniquindio.poo.trabajofinalbiblioteca.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SeleccionRolController {

    private void cargarLogin(String rol) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/trabajofinalbiblioteca/View/LoginView.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Login - " + rol);
            stage.setScene(new Scene(loader.load()));
            stage.show();

            // Cerrar la ventana actual de selección de rol
            Stage ventanaActual = (Stage) loader.getRoot().getScene().getWindow();
            ventanaActual.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void seleccionarAdministrador(ActionEvent event) {
        cargarLogin("Administrador");
    }

    @FXML
    private void seleccionarBibliotecario(ActionEvent event) {
        cargarLogin("Bibliotecario");
    }

    @FXML
    private void seleccionarUsuario(ActionEvent event) {
        cargarLogin("Usuario");
    }
}
