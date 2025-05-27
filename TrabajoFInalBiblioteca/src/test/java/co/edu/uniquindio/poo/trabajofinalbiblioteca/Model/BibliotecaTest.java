package co.edu.uniquindio.poo.trabajofinalbiblioteca.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class BibliotecaTest {

    /**
     * Test de la clase Biblioteca que demuestra el correcto funcionamiento
     * cuando se agrega una persona a la lista de personas con el metodo de agregarPersona
     */
    @Test
    void agregarPersona() {
        Biblioteca biblioteca = new Biblioteca("Central", "001", "Calle 123");
        Persona persona = new Persona("Ana", "1234");
        biblioteca.agregarPersona(persona);
        assertTrue(biblioteca.getListPersonas().contains(persona));
    }

    /**
     * Test para visualizar el toString de una persona desde la clase Biblioteca
     */
    @Test
    void visualizarPersona() {
        Persona persona = new Docente("Ana", "1234");
        Biblioteca biblioteca = new Biblioteca("Central", "001", "Calle 123");
        assertEquals(persona.toString(), biblioteca.visualizarPersona(persona));
    }

    /**
     * Test de actualizar persona desde la clase Biblioteca llamando al metodo actualizar persona
     */
    @Test
    void actualizarPersona() {
        Biblioteca biblioteca = new Biblioteca("Central", "001", "Calle 123");
        Persona persona = new Estudiante("Ana", "1234");
        biblioteca.actualizarPersona(persona, "Maria", "5678");
        assertEquals("Maria", persona.getNombre());
        assertEquals("5678", persona.getId());
    }

    /**
     *Test para eliminar una persona desde la clase Biblioteca primero agregando con el metodo
     * agregarPersona y elimando con el metodo EliminarPersona
     */
    @Test
    void eliminarPersona() {
        Biblioteca biblioteca = new Biblioteca("Central", "001", "Calle 123");
        Persona persona = new Docente("Ana", "1234");
        biblioteca.agregarPersona(persona);
        biblioteca.eliminarPersona(persona);
        assertFalse(biblioteca.getListPersonas().contains(persona));
    }

    /**
     * Test para agregar un empleado desde la clase Biblioteca, con el metodo agregarEmpleado
     */
    @Test
    void agregarEmpleado() {
        Biblioteca biblioteca = new Biblioteca("Central", "001", "Calle 123");
        Empleado empleado = new Bibliotecario("Luis", "123", "correo@uq.edu.co", "user", "pass");
        biblioteca.agregarEmpleado(empleado);
        assertTrue(biblioteca.getListEmpleados().contains(empleado));
    }

    /**
     * Test para visualizar Empleado deade la clase Biblioteca con el metodo VisualizarEmpleado
     * que se muestra con un toString
     */
    @Test
    void visualizarEmpleado() {
        Empleado empleado = new Bibliotecario("Luis", "123", "correo@uq.edu.co", "user", "pass");
        Biblioteca biblioteca = new Biblioteca("Central", "001", "Calle 123");
        assertEquals(empleado.toString(), biblioteca.visualizarEmpleado(empleado));
    }

    /**
     * Test para actualizar empleado desde la clase Biblioteca con el metodo ActualizarEmpleado usando
     * los get de caada modificacion para verificar que el cambio si se haya realizado
     */
    @Test
    void actualizarEmpleado() {
        Empleado empleado = new Bibliotecario("Luis", "123", "correo@uq.edu.co", "user", "pass");
        Biblioteca biblioteca = new Biblioteca("Central", "001", "Calle 123");
        biblioteca.actualizarEmpleado(empleado, "Pedro", "456", "nuevo@uq.edu.co");
        assertEquals("Pedro", empleado.getNombre());
        assertEquals("456", empleado.getId());
        assertEquals("nuevo@uq.edu.co", empleado.getCorreo());
    }

    /**
     * Test para eliminar empleado desde la clase Biblioteca con el metodo de agregar empleado para ahi
     * si eliminarlo con el metodo eliminarEmpleado
     */
    @Test
    void eliminarEmpleado() {
        Biblioteca biblioteca = new Biblioteca("Central", "001", "Calle 123");
        Empleado empleado = new Bibliotecario("Luis", "123", "correo@uq.edu.co", "user", "pass");
        biblioteca.agregarEmpleado(empleado);
        biblioteca.eliminarEmpleado(empleado);
        assertFalse(biblioteca.getListEmpleados().contains(empleado));
    }

    /**
     * Test para agregar un libro a la biblioteca usando el método agregarLibro.
     */
    @Test
    void agregarLibro() {
        Biblioteca biblioteca = new Biblioteca("Central", "001", "Calle 123");
        Libro libro = new Libro("Cien años de soledad", "Gabriel García Márquez", 1967);
        biblioteca.agregarLibro(libro);
        assertTrue(biblioteca.getListLibros().contains(libro));
    }

    /**
     * Test para visualizar la información de un libro mediante el método visualizarLibro,
     * que retorna el resultado del método toString del libro.
     */
    @Test
    void visualizarLibro() {
        Libro libro = new Libro("Cien años de soledad", "Gabriel García Márquez", 1967);
        Biblioteca biblioteca = new Biblioteca("Central", "001", "Calle 123");
        assertEquals(libro.toString(), biblioteca.visualizarLibro(libro));
    }

    /**
     * Test para actualizar los datos de un libro con el método actualizarLibro,
     * y verificar que se hayan aplicado correctamente.
     */
    @Test
    void actualizarLibro() {
        Libro libro = new Libro("Cien años de soledad", "Gabo", 2000);
        Biblioteca biblioteca = new Biblioteca("Central", "001", "Calle 123");
        biblioteca.actualizarLibro(libro, "Nuevo título", "Nuevo autor", 2020, false);
        assertEquals("Nuevo título", libro.getTitulo());
        assertEquals("Nuevo autor", libro.getAutor());
        assertEquals(2020, libro.getAnioPublicacion());
        assertFalse(libro.isDisponibilidad());
    }

    /**
     * Test para eliminar un libro de la biblioteca.
     * El método eliminarEmpleado se utiliza para eliminar el libro, según la implementación actual.
     */
    @Test
    void testEliminarEmpleado() {
        Biblioteca biblioteca = new Biblioteca("Central", "001", "Calle 123");
        Libro libro = new Libro("Libro para eliminar", "Autor", 2023);
        biblioteca.agregarLibro(libro);
        biblioteca.eliminarEmpleado(libro);
        assertFalse(biblioteca.getListLibros().contains(libro));
    }

    /**
     * Test para agregar un préstamo a la biblioteca con el método agregarPrestamo,
     * verificando que se añada correctamente a la lista de préstamos.
     */

    @Test
    void agregarPrestamo() {
        Biblioteca biblioteca = new Biblioteca("Central", "001", "Calle 123");
        Bibliotecario bibliotecario = new Bibliotecario("Luis", "123", "correo@uq.edu.co", "user", "pass");
        Persona persona = new Persona("Carlos", "456");
        Libro libro = new Libro("Libro Prestado", "Autor", 2023);
        Prestamo prestamo = new Prestamo("001", libro, 5, persona, bibliotecario);
        biblioteca.agregarPrestamo(prestamo);
        assertTrue(biblioteca.getListPrestamos().contains(prestamo));
    }
}