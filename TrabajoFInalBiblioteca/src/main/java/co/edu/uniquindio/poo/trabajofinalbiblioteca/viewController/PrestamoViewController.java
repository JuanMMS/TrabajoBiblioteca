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

    @FXML
    private TextField idField;

    @FXML
    private ComboBox<Libro> libroCombo;

    @FXML
    private TextField duracionField;

    @FXML
    private ComboBox<Persona> personaCombo;

    @FXML
    private Button registrarBtn;

    @FXML
    public void initialize() {
        // Cargar libros desde App.biblioteca
        libroCombo.getItems().addAll(App.biblioteca.getListLibros());

        // Personalizar visualización de libros
        libroCombo.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Libro libro, boolean empty) {
                super.updateItem(libro, empty);
                setText((empty || libro == null) ? null : libro.getTitulo());
            }
        });

        libroCombo.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(Libro libro, boolean empty) {
                super.updateItem(libro, empty);
                setText((empty || libro == null) ? null : libro.getTitulo());
            }
        });

        // Cargar personas desde App.biblioteca
        personaCombo.getItems().addAll(App.biblioteca.getListPersonas());

        // Personalizar visualización de personas
        personaCombo.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Persona persona, boolean empty) {
                super.updateItem(persona, empty);
                setText((empty || persona == null) ? null : persona.getNombre() + " (" + persona.getClass().getSimpleName() + ")");
            }
        });

        personaCombo.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(Persona persona, boolean empty) {
                super.updateItem(persona, empty);
                setText((empty || persona == null) ? null : persona.getNombre() + " (" + persona.getClass().getSimpleName() + ")");
            }
        });
    }

    @FXML
    public void registrarPrestamo() {
        try {
            String id = idField.getText();
            Libro libro = libroCombo.getValue();
            int duracion = Integer.parseInt(duracionField.getText());
            Persona persona = personaCombo.getValue();

            if (libro == null || persona == null) {
                mostrarAlerta("Error", "Debe seleccionar un libro y una persona.");
                return;
            }

            Bibliotecario bibliotecario = (Bibliotecario) App.getEmpleadoActual();
            Prestamo prestamo = new Prestamo(id, libro, duracion, persona, bibliotecario);

            App.biblioteca.agregarPrestamo(prestamo);
            bibliotecario.agregarPrestamo(App.biblioteca, prestamo);

            mostrarAlerta("Éxito", "Préstamo registrado correctamente.");

            limpiarCampos();

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "La duración debe ser un número válido.");
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

    private void limpiarCampos() {
        idField.clear();
        duracionField.clear();
        libroCombo.getSelectionModel().clearSelection();
        personaCombo.getSelectionModel().clearSelection();
    }
}
