package co.edu.uniquindio.poo.trabajofinalbiblioteca.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class BibliotecarioTest {

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

        // Marcar solo uno como devuelto (para que haya deuda)
        bibliotecario1.devolverLibro(prestamo1);// este está devuelto
        // prestamo2 y prestamo3 no se devuelven → generan deuda

        // Ejecutar reporte
        String reporte = bibliotecario1.generarReporte();

        // Verificaciones
        assertTrue(reporte.contains("Reporte de préstamos de Pedro:"));
        assertTrue(reporte.contains("Don Quijote"));
        assertTrue(reporte.contains("1984"));

        assertTrue(reporte.contains("Devuelto"));
        assertTrue(reporte.contains("2 veces")); // Don Quijote fue prestado dos veces

        assertTrue(reporte.contains("Lista de personas con deuda:"));
        assertTrue(reporte.contains("Juan")); // usuario con deuda
    }

    @Test
    void listPersonasConDeudaTest() {
        // Crear la biblioteca y el bibliotecario
        Biblioteca biblioteca1 = new Biblioteca("Casa", "1234", "Uniquindio");
        Bibliotecario bibliotecario1 = new Bibliotecario("Pedro", "ABC", "Pedro123@uqvirtual.edu.co", "PedroM12", "12345");

        // Crear usuarios y libros
        Persona usuario1 = new Estudiante("Juan", "111");
        Persona usuario2 = new Docente("Raul", "222");
        LibroFisico libro1 = new LibroFisico("Don Quijote", "Cervantes", 2000, 5500, "Filmore", "L2B");
        LibroFisico libro2 = new LibroFisico("1984", "Orwell", 1985, 422, "Filmore", "L3B");

        // Registrar préstamos
        Prestamo prestamo1 = new Prestamo("1", libro1, 5, usuario1, bibliotecario1);
        Prestamo prestamo2 = new Prestamo("2", libro2, 5, usuario1, bibliotecario1);
        Prestamo prestamo3 = new Prestamo("3", libro1, 5, usuario1, bibliotecario1); // mismo libro otra vez

        //Se agrega los prestamos al bibliotecario
        bibliotecario1.agregarPrestamo(biblioteca1, prestamo1);
        bibliotecario1.agregarPrestamo(biblioteca1, prestamo2);
        bibliotecario1.agregarPrestamo(biblioteca1, prestamo3);

        assertTrue(bibliotecario1.listPersonasConDeuda().contains(usuario1));
    }

    @Test
    void nombrePersonasConDeudaTest() {
        // Crear la biblioteca y el bibliotecario
        Biblioteca biblioteca1 = new Biblioteca("Casa", "1234", "Uniquindio");
        Bibliotecario bibliotecario1 = new Bibliotecario("Pedro", "ABC", "Pedro123@uqvirtual.edu.co", "PedroM12", "12345");

        // Crear usuarios y libros
        Persona usuario1 = new Estudiante("Juan", "111");
        Persona usuario2 = new Docente("Raul", "222");
        Persona usuario3 = new Docente("Cris", "333");
        LibroFisico libro1 = new LibroFisico("Don Quijote", "Cervantes", 2000, 5500, "Filmore", "L2B");
        LibroFisico libro2 = new LibroFisico("1984", "Orwell", 1985, 422, "Filmore", "L3B");
        LibroFisico libro3 = new LibroFisico("21 minutos", "Juan Carlos Bodoque", 2017, 400, "21Min", "L3B");

        // Registrar préstamos
        Prestamo prestamo1 = new Prestamo("1", libro1, 5, usuario1, bibliotecario1);
        Prestamo prestamo2 = new Prestamo("2", libro2, 2, usuario1, bibliotecario1);
        Prestamo prestamo3 = new Prestamo("3", libro1, 3, usuario1, bibliotecario1); // mismo libro otra vez
        Prestamo prestamo4 = new Prestamo("4", libro3, 2, usuario3, bibliotecario1);

        //Se agrega los prestamos al bibliotecario
        bibliotecario1.agregarPrestamo(biblioteca1, prestamo1);
        bibliotecario1.agregarPrestamo(biblioteca1, prestamo2);
        bibliotecario1.agregarPrestamo(biblioteca1, prestamo3);
        bibliotecario1.agregarPrestamo(biblioteca1, prestamo4);

        //verificaciones
        assertTrue(bibliotecario1.nombrePersonasConDeuda().contains("Juan"));
        assertTrue(bibliotecario1.nombrePersonasConDeuda().contains("Cris"));


    }

    @Test
    void libroMasPrestadoTest() {
        // Crear la biblioteca y el bibliotecario
        Biblioteca biblioteca1 = new Biblioteca("Casa", "1234", "Uniquindio");
        Bibliotecario bibliotecario1 = new Bibliotecario("Pedro", "ABC", "Pedro123@uqvirtual.edu.co", "PedroM12", "12345");

        // Crear usuarios y libros
        Persona usuario1 = new Estudiante("Juan", "111");
        Persona usuario2 = new Docente("Raul", "222");
        Persona usuario3 = new Docente("Cris", "333");
        LibroFisico libro1 = new LibroFisico("Don Quijote", "Cervantes", 2000, 5500, "Filmore", "L2B");
        LibroFisico libro2 = new LibroFisico("1984", "Orwell", 1985, 422, "Filmore", "L3B");
        LibroFisico libro3 = new LibroFisico("21 minutos", "Juan Carlos Bodoque", 2017, 400, "21Min", "L3B");

        // Registrar préstamos
        Prestamo prestamo1 = new Prestamo("1", libro1, 5, usuario1, bibliotecario1);
        Prestamo prestamo2 = new Prestamo("2", libro2, 2, usuario1, bibliotecario1);
        Prestamo prestamo3 = new Prestamo("3", libro1, 3, usuario1, bibliotecario1); // mismo libro otra vez
        Prestamo prestamo4 = new Prestamo("4", libro3, 2, usuario3, bibliotecario1);

        //Se agrega los prestamos al bibliotecario
        bibliotecario1.agregarPrestamo(biblioteca1, prestamo1);
        bibliotecario1.agregarPrestamo(biblioteca1, prestamo2);
        bibliotecario1.agregarPrestamo(biblioteca1, prestamo3);
        bibliotecario1.agregarPrestamo(biblioteca1, prestamo4);


        assertTrue(bibliotecario1.libroMasPrestado().contains("Don Quijote"));



    }

    @Test
    void stringDisponibilidadTest() {
        // Crear la biblioteca y el bibliotecario
        Biblioteca biblioteca1 = new Biblioteca("Casa", "1234", "Uniquindio");
        Bibliotecario bibliotecario1 = new Bibliotecario("Pedro", "ABC", "Pedro123@uqvirtual.edu.co", "PedroM12", "12345");
        String disponibilidadString = bibliotecario1.stringDisponibilidad(true);

        //Verificacion
        assertTrue(disponibilidadString.contains("Devuelto"));

    }

    @Test
    void nombrePersonasConDeuda() {
        // Crear la biblioteca y el bibliotecario
        Biblioteca biblioteca1 = new Biblioteca("Casa", "1234", "Uniquindio");
        Bibliotecario bibliotecario1 = new Bibliotecario("Pedro", "ABC", "Pedro123@uqvirtual.edu.co", "PedroM12", "12345");

        // Crear usuarios y libros
        Persona usuario1 = new Estudiante("Juan", "111");
        Persona usuario2 = new Docente("Raul", "222");
        Persona usuario3 = new Docente("Cris", "333");
        LibroFisico libro1 = new LibroFisico("Don Quijote", "Cervantes", 2000, 5500, "Filmore", "L2B");
        LibroFisico libro2 = new LibroFisico("1984", "Orwell", 1985, 422, "Filmore", "L3B");
        LibroFisico libro3 = new LibroFisico("21 minutos", "Juan Carlos Bodoque", 2017, 400, "21Min", "L3B");

        // Registrar préstamos
        Prestamo prestamo1 = new Prestamo("1", libro1, 5, usuario1, bibliotecario1);
        Prestamo prestamo2 = new Prestamo("2", libro2, 2, usuario1, bibliotecario1);
        Prestamo prestamo3 = new Prestamo("3", libro1, 3, usuario1, bibliotecario1); // mismo libro otra vez
        Prestamo prestamo4 = new Prestamo("4", libro3, 2, usuario3, bibliotecario1);

        //Se agrega los prestamos al bibliotecario
        bibliotecario1.agregarPrestamo(biblioteca1, prestamo1);
        bibliotecario1.agregarPrestamo(biblioteca1, prestamo2);
        bibliotecario1.agregarPrestamo(biblioteca1, prestamo3);
        bibliotecario1.agregarPrestamo(biblioteca1, prestamo4);

        //Verificaciones
        assertTrue(bibliotecario1.nombrePersonasConDeuda().contains("Juan"));
        assertTrue(bibliotecario1.nombrePersonasConDeuda().contains("Cris"));
    }

    @Test
    void agregarLibroTest() {
        // Crear la biblioteca, el bibliotecario y el libro
        Biblioteca biblioteca1 = new Biblioteca("Casa", "1234", "Uniquindio");
        Bibliotecario bibliotecario1 = new Bibliotecario("Pedro", "ABC", "Pedro123@uqvirtual.edu.co", "PedroM12", "12345");
        LibroFisico libro1 = new LibroFisico("Don Quijote", "Cervantes", 2000, 5500, "Filmore", "L2B");

        //Se agrega el libro a la biblioteca
        bibliotecario1.agregarLibro(biblioteca1, libro1);

        //verificación
        assertTrue(biblioteca1.getListLibros().contains(libro1));

    }

    @Test
    void devolverLibro() {
        // Crear la biblioteca y el bibliotecario
        Biblioteca biblioteca1 = new Biblioteca("Casa", "1234", "Uniquindio");
        Bibliotecario bibliotecario1 = new Bibliotecario("Pedro", "ABC", "Pedro123@uqvirtual.edu.co", "PedroM12", "12345");

        // Crear usuario y libro
        Persona usuario1 = new Estudiante("Juan", "111");

        LibroFisico libro1 = new LibroFisico("Don Quijote", "Cervantes", 2000, 5500, "Filmore", "L2B");

        // Registrar préstamo
        Prestamo prestamo1 = new Prestamo("1", libro1, 5, usuario1, bibliotecario1);
        //Se agrega los prestamos al bibliotecario
        bibliotecario1.agregarPrestamo(biblioteca1, prestamo1);

        //Se devuelve el libro prestado
        bibliotecario1.devolverLibro(prestamo1);
        //Tomamos el estado del prestamo
        boolean libroDevuelto = prestamo1.isDevuelto();

        assertTrue(libroDevuelto);

    }

    @Test
    void agregarPersona() {
        // Crear la biblioteca y el bibliotecario
        Biblioteca biblioteca1 = new Biblioteca("Casa", "1234", "Uniquindio");
        Bibliotecario bibliotecario1 = new Bibliotecario("Pedro", "ABC", "Pedro123@uqvirtual.edu.co", "PedroM12", "12345");
        // Crear usuario
        Persona usuario1 = new Estudiante("Juan", "111");

        //Agregar persona a biblioteca mediante bibliotecario
        bibliotecario1.agregarPersona(biblioteca1, usuario1);
        //verificación
        assertTrue(biblioteca1.getListPersonas().contains(usuario1));

    }

    @Test
    void visualizarPersona() {
        // Crear la biblioteca y el bibliotecario
        Biblioteca biblioteca1 = new Biblioteca("Casa", "1234", "Uniquindio");
        Bibliotecario bibliotecario1 = new Bibliotecario("Pedro", "ABC", "Pedro123@uqvirtual.edu.co", "PedroM12", "12345");
        // Crear usuario
        Persona usuario1 = new Estudiante("Juan", "111");

        //Agregar persona a biblioteca mediante bibliotecario
        bibliotecario1.agregarPersona(biblioteca1, usuario1);

        //Visualizar
        String esperado = usuario1.toString();
        String resultado = bibliotecario1.visualizarPersona(biblioteca1, usuario1);

        assertEquals(esperado, resultado);
    }

    @Test
    void actualizarPersonaTest() {
        //Creamos biblioteca, persona y bibliotecario
        Biblioteca biblioteca = new Biblioteca("Los libros", "444", "cr19N");
        Persona persona = new Persona("Carlos", "300");
        Bibliotecario bibliotecario = new Bibliotecario("Admin", "001", "admin@uq.edu.co", "admin", "admin123");
        //Actualizamos la información de una persona
        bibliotecario.actualizarPersona(biblioteca, persona ,"Carlos Pérez", "999");

        //Verificaciones
        assertEquals("Carlos Pérez", persona.getNombre());
        assertEquals("999", persona.getId());
    }

    @Test
    void eliminarPersona() {
        //Creamos biblioteca, persona y bibliotecario
        Biblioteca biblioteca = new Biblioteca("Los libros", "444", "cr19N");
        Persona persona = new Persona("Carlos", "300");
        Bibliotecario bibliotecario = new Bibliotecario("Admin", "001", "admin@uq.edu.co", "admin", "admin123");
        //Verificaciones
        bibliotecario.eliminarPersona(biblioteca, persona);
        assertFalse(biblioteca.getListPersonas().contains(persona));
    }

    @Test
    void agregarPrestamo() {
        // Crear la biblioteca y el bibliotecario
        Biblioteca biblioteca1 = new Biblioteca("Casa", "1234", "Uniquindio");
        Bibliotecario bibliotecario1 = new Bibliotecario("Pedro", "ABC", "Pedro123@uqvirtual.edu.co", "PedroM12", "12345");
        // Crear usuarios y libros
        Persona usuario1 = new Estudiante("Juan", "111");
        LibroFisico libro1 = new LibroFisico("Don Quijote", "Cervantes", 2000, 5500, "Filmore", "L2B");
        // Registrar préstamos
        Prestamo prestamo1 = new Prestamo("1", libro1, 5, usuario1, bibliotecario1);

        //Se agrega los prestamos al bibliotecario
        bibliotecario1.agregarPrestamo(biblioteca1, prestamo1);

        //verificacion
        assertTrue(biblioteca1.getListPrestamos().contains(prestamo1));

    }
}