package co.edu.uniquindio.poo.trabajofinalbiblioteca.controller;

import co.edu.uniquindio.poo.trabajofinalbiblioteca.Model.Biblioteca;
import co.edu.uniquindio.poo.trabajofinalbiblioteca.Model.Empleado;
import co.edu.uniquindio.poo.trabajofinalbiblioteca.Model.Libro;

public class BibliotecaController {

    private Biblioteca biblioteca;

    public BibliotecaController(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void agregarEmpleado(Empleado empleado) {
        biblioteca.agregarEmpleado(empleado);
    }

    public void agregarLibro(Libro libro) {
        biblioteca.agregarLibro(libro);
    }

    public String mostrarEmpleados() {
        StringBuilder resultado = new StringBuilder("Empleados:\n");
        for (Empleado e : biblioteca.getListEmpleados()) {
            resultado.append(e.toString()).append("\n");
        }
        return resultado.toString();
    }

    public String mostrarLibros() {
        StringBuilder resultado = new StringBuilder("Libros:\n");
        for (Libro l : biblioteca.getListLibros()) {
            resultado.append(l.toString()).append("\n");
        }
        return resultado.toString();
    }
}
