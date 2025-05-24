package co.edu.uniquindio.poo.trabajofinalbiblioteca.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class BibliotecarioTest {

    @Test
    void generarReporteTest() {
        Biblioteca biblioteca1 = new Biblioteca("Casa", "1234", "Uniquindio");
        Bibliotecario bibliotecario1 = new Bibliotecario(biblioteca1, "Pedro", "ABC", "perdro@mail.com", "Pedro22", "Admin");
        Estudiante estudiante1 = new Estudiante("Esteban", "DEF");
        Docente docente1 = new Docente("Raul", "456");

        LibroFisico libro = new LibroFisico("200 Años de soledad", "Marquez García", 2000, true, 199, "Norma", "A2");

        Prestamo prestamo = new Prestamo("XYZ1", libro, 2, estudiante1, bibliotecario1);
        libro.setDisponibilidad(false);
        bibliotecario1.agregarPrestamo(prestamo);
    }
}