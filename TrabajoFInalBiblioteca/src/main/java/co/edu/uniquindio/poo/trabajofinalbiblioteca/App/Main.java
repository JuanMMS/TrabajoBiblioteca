package co.edu.uniquindio.poo.trabajofinalbiblioteca.App;

import co.edu.uniquindio.poo.trabajofinalbiblioteca.Model.*;

public class Main {
    Biblioteca biblioteca = new Biblioteca("Los libros", "123A", "Cra 14, #5");
    Bibliotecario bibliotecario = new Bibliotecario(biblioteca, "Ivan", "456B", "ivan@gmail.com", "Ivan123", "admin");
    Administrador admin = new Administrador(biblioteca, "admin", "789C", "admin@gmail.com", "admin123", "admin123");
    Docente docente = new Docente("Raul", "111AB");
    Estudiante estudiante = new Estudiante("Esteban", "222B");
    Visitante visitante = new Visitante("Clara", "333B");
    LibroDigital libroDigital = new LibroDigital("Matemáticas generales", "Lucas", 2015, "www.librodigital.com", TipoFormato.PDF);
    LibroReferencia libroReferencia = new LibroReferencia("Libro de Gamer", "Pepe", 2022);

}
