package co.edu.uniquindio.poo.trabajofinalbiblioteca.Model;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdministradorTest {

    @Test
    public void testGenerarReporte() {
        Bibliotecario bibliotecario1 = new Bibliotecario("Luis", "123", "luis@uq.edu.co", "luis123", "clave123");
        Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", 2015);
        Libro libro2 = new Libro("El coronel no tiene quien le escriba", "Gabriel García Márquez", 2010);
        Persona persona1 = new Persona("Ana", "321");
        Persona persona2 = new Persona("Carlos", "654");
        Prestamo prestamo1 = new Prestamo("555", libro1, 2, persona1, bibliotecario1);
        Prestamo prestamo2 = new Prestamo("777", libro2, 7, persona2, bibliotecario1);
        bibliotecario1.getListPrestamosBibliotecario().add(prestamo1);
        bibliotecario1.getListPrestamosBibliotecario().add(prestamo2);
        Administrador admin = new Administrador("Admin", "001", "admin@uq.edu.co", "admin", "admin123");
        String reporte = admin.generarReporte(bibliotecario1);
        String esperado = prestamo1.toString() + "\n" + prestamo2.toString() + "\n";

        assertEquals(esperado, reporte);
    }



    @Test
    void agregarEmpleado() {
        Biblioteca biblioteca = new Biblioteca("Los libros", "444", "cr19N");
        Administrador admin = new Administrador("Admin", "001", "admin@uq.edu.co", "admin", "admin123");
        Empleado nuevoEmpleado = new Bibliotecario("Laura", "100", "laura@uq.edu.co", "laura123", "clave123");
        admin.agregarEmpleado(biblioteca, nuevoEmpleado);
        assertTrue(biblioteca.getListEmpleados().contains(nuevoEmpleado));
    }

    @Test
    void visualizarEmpleado() {
        Biblioteca biblioteca = new Biblioteca("Los libros", "444", "cr19N");
        Empleado empleado = new Bibliotecario("Juan", "200", "juan@uq.edu.co", "juan123", "clave123");
        Administrador admin = new Administrador("Admin", "001", "admin@uq.edu.co", "admin", "admin123");
        String esperado = empleado.toString();
        String resultado = admin.visualizarEmpleado(biblioteca, empleado);

        assertEquals(esperado, resultado);
    }

    @Test
    void actualizarEmpleado() {
        Biblioteca biblioteca = new Biblioteca("Los libros", "444", "cr19N");
        Empleado empleado = new Bibliotecario("Carlos", "300", "carlos@correo.com", "carlos123", "clave123");
        Administrador admin = new Administrador("Admin", "001", "admin@uq.edu.co", "admin", "admin123");
        admin.actualizarEmpleado(biblioteca, empleado, "Carlos Pérez", "999", "carlosp@correo.com");
        assertEquals("Carlos Pérez", empleado.getNombre());
        assertEquals("999", empleado.getId());
        assertEquals("carlosp@correo.com", empleado.getCorreo());

    }

    @Test
    void eliminarEmpleado() {
        Biblioteca biblioteca = new Biblioteca("Los libros", "444", "cr19N");
        Empleado empleado = new Administrador("Sara", "400", "sara@correo.com", "sara123", "clave123");
        biblioteca.getListEmpleados().add(empleado);
        Administrador admin = new Administrador("Admin", "001", "admin@uq.edu.co", "admin", "admin123");
        admin.eliminarEmpleado(biblioteca, empleado);
        assertFalse(biblioteca.getListEmpleados().contains(empleado));
    }
}