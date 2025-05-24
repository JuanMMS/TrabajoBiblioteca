package co.edu.uniquindio.poo.trabajofinalbiblioteca.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaTest {

    @Test
    void agregarEmpleadoTest() {
        Biblioteca biblioteca = new Biblioteca("Los libres", "123A", "Cra 4, Mz 20");
        Empleado empleado = new Bibliotecario("Juan José", "10987", "juanjo@gmail.com", "JuanJ22", "ABCD123");
        biblioteca.agregarEmpleado(biblioteca, empleado);
        assertTrue(biblioteca.getListEmpleados().contains(empleado));
    }

    @Test
    void visualizarEmpleadoTest() {
    }

    @Test
    void actualizarEmpleadoTest() {
    }

    @Test
    void eliminarEmpleadoTest() {
    }

    @Test
    void agregarLibroTest() {
    }

    @Test
    void visualizarLibroTest() {
    }

    @Test
    void actualizarLibroTest() {
    }

    @Test
    void testEliminarEmpleadoTest() {
    }
}