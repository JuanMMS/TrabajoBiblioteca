package co.edu.uniquindio.poo.trabajofinalbiblioteca.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class BibliotecarioTest {



   /** void generarReporteTest() {
        Biblioteca biblioteca1 = new Biblioteca("Casa", "1234", "Uniquindio");
        Bibliotecario bibliotecario1 = new Bibliotecario(biblioteca1, "Pedro", "ABC", "perdro@mail.com", "Pedro22", "Admin");
        Estudiante estudiante1 = new Estudiante("Esteban", "DEF");
        Docente docente1 = new Docente("Raul", "456");
    LibroFisico libro = new LibroFisico("200 Años de soledad", "Marquez García", 2000, true, 199, "Norma", "A2");
    */



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

        bibliotecario1.agregarPrestamo(prestamo1);
        bibliotecario1.agregarPrestamo(prestamo2);
        bibliotecario1.agregarPrestamo(prestamo3);

        // Marcar solo uno como devuelto (para que haya deuda)
        prestamo1.setDevuelto(true); // este está devuelto
        // prestamo2 y prestamo3 no se devuelven → generan deuda

        // Ejecutar reporte
        String reporte = bibliotecario1.generarReporte();

        // Verificaciones
        assertTrue(reporte.contains("Reporte de préstamos de Pedro:"));
        assertTrue(reporte.contains("Don Quijote"));
        assertTrue(reporte.contains("1984"));

        assertTrue(reporte.contains("Libro más prestado: Don Quijote"));
        assertTrue(reporte.contains("2 veces")); // Don Quijote fue prestado dos veces

        assertTrue(reporte.contains("Usuarios con deudas:"));
        assertTrue(reporte.contains("Juan")); // usuario con deuda
    }
}