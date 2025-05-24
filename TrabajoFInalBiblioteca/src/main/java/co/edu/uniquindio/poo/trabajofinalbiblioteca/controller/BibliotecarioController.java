package co.edu.uniquindio.poo.trabajofinalbiblioteca.controller;

import co.edu.uniquindio.poo.trabajofinalbiblioteca.Model.Biblioteca;
import co.edu.uniquindio.poo.trabajofinalbiblioteca.Model.Bibliotecario;
import co.edu.uniquindio.poo.trabajofinalbiblioteca.Model.Prestamo;

public class BibliotecarioController {

    private Bibliotecario bibliotecario;

    public BibliotecarioController(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public void agregarPrestamo(Biblioteca biblioteca, Prestamo prestamo) {
        biblioteca.agregarPrestamo(prestamo);
    }

    public void devolverLibro(Prestamo prestamo) {
        bibliotecario.devolverLibro(prestamo);
    }

    public String generarReporte() {
        return bibliotecario.generarReporte();
    }

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }
}