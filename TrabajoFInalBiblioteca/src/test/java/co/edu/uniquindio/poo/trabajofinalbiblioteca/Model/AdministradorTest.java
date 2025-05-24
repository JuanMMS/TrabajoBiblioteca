package co.edu.uniquindio.poo.trabajofinalbiblioteca.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdministradorTest {

    @Test
    void generarReporteTest() {
        // Crear la biblioteca y el bibliotecario
        Biblioteca biblioteca1 = new Biblioteca("Casa", "1234", "Uniquindio");
        Bibliotecario bibliotecario1 = new Bibliotecario("Pedro", "ABC", "Pedro123@uqvirtual.edu.co", "PedroM12", "12345");

        // Crear usuarios y libros
        Persona usuario1 = new Estudiante("Juan", "111");
        LibroFisico libro1 = new LibroFisico("Don Quijote", "Cervantes", 2000, 5500, "Filmore", "L2B");
        LibroFisico libro2 = new LibroFisico("1984", "Orwell", 1985, 422, "Filmore", "L3B");

        // Registrar préstamos
        Prestamo prestamo1 = new Prestamo("1", libro1, 5, usuario1, bibliotecario1);
        Prestamo prestamo2 = new Prestamo("2", libro2, 5, usuario1, bibliotecario1);
        Prestamo prestamo3 = new Prestamo("3", libro1, 5, usuario1, bibliotecario1); // mismo libro otra vez

        bibliotecario1.agregarPrestamo(biblioteca1, prestamo1);
        bibliotecario1.agregarPrestamo(biblioteca1, prestamo2);
        bibliotecario1.agregarPrestamo(biblioteca1, prestamo3);

        assertEquals(bibliotecario1.getListPrestamosBibliotecario().toString(), bibliotecario1.generarReporte());

    }
}