package co.edu.uniquindio.poo.trabajofinalbiblioteca.controller;

import co.edu.uniquindio.poo.trabajofinalbiblioteca.Model.Biblioteca;
import co.edu.uniquindio.poo.trabajofinalbiblioteca.Model.Bibliotecario;
import co.edu.uniquindio.poo.trabajofinalbiblioteca.Model.Libro;
import co.edu.uniquindio.poo.trabajofinalbiblioteca.Model.Persona;
import co.edu.uniquindio.poo.trabajofinalbiblioteca.Model.Prestamo;

public class BibliotecarioController {

    private final Bibliotecario bibliotecario;

    public BibliotecarioController(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public void agregarPrestamo(Biblioteca biblioteca, Prestamo prestamo) {
        bibliotecario.agregarPrestamo(biblioteca, prestamo);
    }

    public void devolverLibro(Prestamo prestamo) {
        bibliotecario.devolverLibro(prestamo);
    }

    public String generarReporte() {
        return bibliotecario.generarReporte();
    }

    public void agregarLibro(Biblioteca biblioteca, Libro libro) {
        bibliotecario.agregarLibro(biblioteca, libro);
    }

    public void agregarPersona(Biblioteca biblioteca, Persona persona) {
        bibliotecario.agregarPersona(biblioteca, persona);
    }

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }
}