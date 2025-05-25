package co.edu.uniquindio.poo.trabajofinalbiblioteca.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PrimaryController {

    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    private void abrirLogin() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/trabajofinalbiblioteca/Login.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Iniciar Sesión");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



