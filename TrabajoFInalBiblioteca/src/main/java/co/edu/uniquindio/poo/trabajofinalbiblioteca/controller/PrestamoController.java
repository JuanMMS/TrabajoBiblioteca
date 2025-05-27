package co.edu.uniquindio.poo.trabajofinalbiblioteca.controller;

import co.edu.uniquindio.poo.trabajofinalbiblioteca.App;
import co.edu.uniquindio.poo.trabajofinalbiblioteca.Model.*;

import javafx.scene.Node;
import javafx.stage.Stage;

public class PrestamoController {

    public void crearPrestamo(String id, Libro libro, Persona persona, int duracion) {
        Bibliotecario bibliotecario = (Bibliotecario) App.biblioteca.getEmpleadoActual();

        Prestamo prestamo = new Prestamo(id, libro, duracion, persona, bibliotecario);
        App.biblioteca.agregarPrestamo(prestamo);
        bibliotecario.agregarPrestamo(App.biblioteca, prestamo);
    }

    public void volverABibliotecario(Node node) {
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }
}
