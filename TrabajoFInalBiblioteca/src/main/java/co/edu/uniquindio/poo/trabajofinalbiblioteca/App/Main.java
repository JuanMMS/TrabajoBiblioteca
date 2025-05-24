package co.edu.uniquindio.poo.trabajofinalbiblioteca.App;

import co.edu.uniquindio.poo.trabajofinalbiblioteca.Model.*;

public class Main {
    Biblioteca biblioteca = new Biblioteca("Los libros", "123A", "Cra 14, #5");
    Bibliotecario bibliotecario = new Bibliotecario("Ivan", "456B", "ivan@gmail.com", "Ivan123", "admin");
    Administrador admin = new Administrador("admin", "789C", "admin@gmail.com", "admin123", "admin123");
    Docente docente = new Docente("Raul", "111AB");
    Estudiante estudiante = new Estudiante("Esteban", "222B");
    Visitante visitante = new Visitante("Clara", "333B");
    LibroDigital libroDigital = new LibroDigital("Matemáticas generales", "Lucas", 2015, "www.librodigital.com", TipoFormato.PDF);
    LibroReferencia libroReferencia = new LibroReferencia("Libro de Gamer", "Pepe", 2022);
    LibroFisico libroFisico1 = new LibroFisico("Crimen y castigo", "Fiodor", 1925, 200, "Normal", "A22");
    LibroFisico libroFisico2 = new LibroFisico("100 años de soledad", "Gabriel", 1980, 170, "Normal", "A24");
    LibroFisico libroFisico3 = new LibroFisico("La ciudad y los perros", "Andres", 2001, 210, "Caracol", "A24");
    Prestamo prestamo1 = new Prestamo("1A2B", libroFisico1, 2, estudiante, bibliotecario);
    Prestamo prestamo2 = new Prestamo("2C,3D", libroFisico2, 1, estudiante, bibliotecario);





}
