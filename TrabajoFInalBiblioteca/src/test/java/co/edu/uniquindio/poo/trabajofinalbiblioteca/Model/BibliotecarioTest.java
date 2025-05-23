package co.edu.uniquindio.poo.trabajofinalbiblioteca.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class BibliotecarioTest {

    @Test
    void generarReporte() {
        // Crear la biblioteca y el bibliotecario
        Biblioteca biblioteca1 = new Biblioteca("Casa", "1234", "Uniquindio");
        Bibliotecario bibliotecario1 = new Bibliotecario(biblioteca1, "Pedro", "ABC", "Pedro123@uqvirtual.edu.co", "PedroM12", "12345");

        // Crear usuarios y libros
        Persona usuario1 = new Estudiante("Juan", "111");
        Libro libro1 = new LibroFisico("Don Quijote", "Cervantes", 2000, true, 5500, "Filmore", "L2B");
        Libro libro2 = new LibroFisico("1984", "Orwell", 1985, true, 422, "filmore", "L3B");
        Libro libro3 = new LibroFisico("Mil Leguas", "Nunies", 1990, true, 2, "Perdon", "L34C");

        // Registrar préstamos
        Prestamo prestamo1 = new Prestamo("1", libro1, 5, usuario1, bibliotecario1);
        Prestamo prestamo2 = new Prestamo("2", libro2, 5, usuario1, bibliotecario1);
        Prestamo prestamo3 = new Prestamo("3", libro1, 5, usuario1, bibliotecario1); // mismo libro otra vez

        bibliotecario1.getListPrestamosBibliotecario().add(prestamo1);
        bibliotecario1.getListPrestamosBibliotecario().add(prestamo2);
        bibliotecario1.getListPrestamosBibliotecario().add(prestamo3);

        // Ejecutar reporte
        String reporte = bibliotecario1.generarReporte().toString();

        // Verificar contenido del reporte
        assertTrue(reporte.contains("Resumen de préstamos de Pedro"));
        assertTrue(reporte.contains("Don Quijote"));
        assertTrue(reporte.contains("1984"));
        assertTrue(reporte.contains("Libros más prestados"));
        assertTrue(reporte.contains("Veces prestado: 2")); // Don Quijote
        assertTrue(reporte.contains("Veces prestado: 1")); // 1984
    }
}