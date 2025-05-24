package co.edu.uniquindio.poo.trabajofinalbiblioteca.viewController;

import co.edu.uniquindio.poo.trabajofinalbiblioteca.controller.BibliotecaController;
import co.edu.uniquindio.poo.trabajofinalbiblioteca.Model.Biblioteca;
import co.edu.uniquindio.poo.trabajofinalbiblioteca.Model.Empleado;
import co.edu.uniquindio.poo.trabajofinalbiblioteca.Model.Libro;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class BibliotecaViewController {

    public TextArea librosTextArea;
    public TextArea empleadosTextArea;
    private BibliotecaController bibliotecaController;

    @FXML
    private TextField nombreEmpleadoField, idEmpleadoField, correoEmpleadoField;
    @FXML
    private TextField tituloLibroField, autorLibroField, anioLibroField;
    @FXML
    private CheckBox disponibilidadLibroCheck;
    @FXML
    private TextArea resultadoArea;

    public void inicializar(Biblioteca biblioteca) {
        this.bibliotecaController = new BibliotecaController(biblioteca);
    }

    @FXML
    public void agregarEmpleado() {
        Empleado empleado = new Empleado(nombreEmpleadoField.getText(), idEmpleadoField.getText(), correoEmpleadoField.getText(), "Juan", "1234") {
            @Override
            public String generarReporte() {
                return "";
            }
        };
        bibliotecaController.agregarEmpleado(empleado);
        resultadoArea.setText("Empleado agregado exitosamente.");
    }

    @FXML
    public void agregarLibro() {
        try {
            int anio = Integer.parseInt(anioLibroField.getText());
            Libro libro = new Libro(tituloLibroField.getText(), autorLibroField.getText(), anio);
            libro.setDisponibilidad(disponibilidadLibroCheck.isSelected());
            bibliotecaController.agregarLibro(libro);
            resultadoArea.setText("Libro agregado exitosamente.");
        } catch (NumberFormatException e) {
            resultadoArea.setText("Error: año de publicación inválido.");
        }
    }

    @FXML
    public void mostrarEmpleados() {
        resultadoArea.setText(bibliotecaController.mostrarEmpleados());
    }

    @FXML
    public void mostrarLibros() {
        resultadoArea.setText(bibliotecaController.mostrarLibros());
    }
}