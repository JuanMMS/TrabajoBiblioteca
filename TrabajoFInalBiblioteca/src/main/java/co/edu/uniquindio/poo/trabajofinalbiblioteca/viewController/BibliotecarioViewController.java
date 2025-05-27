package co.edu.uniquindio.poo.trabajofinalbiblioteca.viewController;

import co.edu.uniquindio.poo.trabajofinalbiblioteca.Model.Biblioteca;
import co.edu.uniquindio.poo.trabajofinalbiblioteca.Model.Bibliotecario;
import co.edu.uniquindio.poo.trabajofinalbiblioteca.Model.LibroFisico;
import co.edu.uniquindio.poo.trabajofinalbiblioteca.Model.Persona;
import co.edu.uniquindio.poo.trabajofinalbiblioteca.Model.Estudiante;
import co.edu.uniquindio.poo.trabajofinalbiblioteca.controller.BibliotecarioController;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class BibliotecarioViewController {

    @FXML
    private TextArea reporteTextArea;

    @FXML
    private TextField nombreLibroField;

    @FXML
    private TextField nombrePersonaField;

    private BibliotecarioController bibliotecarioController;
    private Biblioteca biblioteca;

    public void setBibliotecaYBibliotecario(Biblioteca biblioteca, Bibliotecario bibliotecario) {
        this.biblioteca = biblioteca;
        this.bibliotecarioController = new BibliotecarioController(bibliotecario);
    }

    @FXML
    private void generarReporte() {
        String reporte = bibliotecarioController.generarReporte();
        reporteTextArea.setText(reporte);
    }

    @FXML
    private void agregarLibro() {
        String nombreLibro = nombreLibroField.getText();
        if (!nombreLibro.isEmpty()) {
            LibroFisico libro = new LibroFisico(nombreLibro, "Autor", 2024, 100, "Normal", "A1");
            bibliotecarioController.agregarLibro(biblioteca, libro);
            reporteTextArea.setText("Libro agregado: " + nombreLibro);
            nombreLibroField.clear();
        }
    }

    @FXML
    private void agregarPersona() {
        String nombrePersona = nombrePersonaField.getText();
        if (!nombrePersona.isEmpty()) {
            Persona persona = new Estudiante(nombrePersona, "X001");
            bibliotecarioController.agregarPersona(biblioteca, persona);
            reporteTextArea.setText("Persona agregada: " + nombrePersona);
            nombrePersonaField.clear();
        }
    }
}