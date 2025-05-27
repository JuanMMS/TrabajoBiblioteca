package co.edu.uniquindio.poo.trabajofinalbiblioteca.viewController;

import co.edu.uniquindio.poo.trabajofinalbiblioteca.App;
import co.edu.uniquindio.poo.trabajofinalbiblioteca.Model.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class PrestamoViewController {

    @FXML private TextField idField;
    @FXML private ComboBox<Libro> libroCombo;
    @FXML private TextField duracionField;
    @FXML private TextField personaField;
    @FXML private Button registrarBtn;

    @FXML
    public void initialize() {
        libroCombo.getItems().addAll(App.biblioteca.getListLibros());
    }

    @FXML
    public void registrarPrestamo() {
        try {
            String id = idField.getText();
            Libro libro = libroCombo.getValue();
            int duracion = Integer.parseInt(duracionField.getText());
            String nombrePersona = personaField.getText();

            Persona persona = App.biblioteca.buscarPersona(nombrePersona);
            Bibliotecario bibliotecario = (Bibliotecario) App.getEmpleadoActual();

            Prestamo prestamo = new Prestamo(id, libro, duracion, persona, bibliotecario);
            App.biblioteca.agregarPrestamo(prestamo);
            bibliotecario.agregarPrestamo(App.biblioteca, prestamo);

            mostrarAlerta("Éxito", "Préstamo registrado correctamente.");

        } catch (Exception e) {
            mostrarAlerta("Error", "Error al registrar el préstamo: " + e.getMessage());
        }
    }

    @FXML
    public void volverABibliotecario() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/trabajofinalbiblioteca/bibliotecario_view.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) registrarBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
