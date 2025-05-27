package co.edu.uniquindio.poo.trabajofinalbiblioteca.controller;

import co.edu.uniquindio.poo.trabajofinalbiblioteca.App;
import co.edu.uniquindio.poo.trabajofinalbiblioteca.Model.*;

import java.util.List;

public class BibliotecarioController {

    private final Bibliotecario bibliotecario;

    public BibliotecarioController(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }
    // ========== PERSONAS ==========

    public void agregarPersona(Persona persona) {
        App.biblioteca.agregarPersona(persona);
        bibliotecario.agregarPersona(App.biblioteca, persona);
    }

    public void actualizarPersona(Persona persona, String nombre, String id) {
        App.biblioteca.actualizarPersona(persona, nombre, id);
        bibliotecario.actualizarPersona(App.biblioteca, persona, nombre, id);
    }

    public void eliminarPersona(Persona persona) {
        App.biblioteca.eliminarPersona(persona);
        bibliotecario.eliminarPersona(App.biblioteca, persona);
    }

    public String visualizarPersona(Persona persona) {
        return App.biblioteca.visualizarPersona(persona);
    }

    // ========== LIBROS ==========

    public void agregarLibro(Libro libro) {
        App.biblioteca.agregarLibro(libro);
        bibliotecario.agregarLibro(App.biblioteca, libro);
    }

    public void devolverLibro(Prestamo prestamo) {
        bibliotecario.devolverLibro(prestamo);
    }

    // ========== PRÉSTAMOS ==========

    public void agregarPrestamo(Prestamo prestamo) {
        bibliotecario.agregarPrestamo(App.biblioteca, prestamo);
    }

    public List<Prestamo> obtenerPrestamos() {
        return bibliotecario.getListPrestamosBibliotecario();
    }

    // ========== REPORTES ==========

    public String generarReporte() {
        return bibliotecario.generarReporte();
    }

    // ========== GETTER ==========

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }
}