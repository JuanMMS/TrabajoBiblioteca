package co.edu.uniquindio.poo.trabajofinalbiblioteca;

import co.edu.uniquindio.poo.trabajofinalbiblioteca.Model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    private Stage primaryStage;
    public static Biblioteca biblioteca = new Biblioteca("Los libros", "123A", "Cra 14, #5");

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Biblioteca");
        inicializarData();
        openPrimaryView();
    }

    private void openPrimaryView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/trabajofinalbiblioteca/Primary.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    //servicios, data basica para la función del programa

    public void inicializarData() {
        Bibliotecario bibliotecario1 = new Bibliotecario("Ivan", "456B", "ivan@gmail.com", "Ivan123", "admin");
        Administrador admin = new Administrador("admin", "789C", "admin@gmail.com", "admin123", "admin123");
        Docente docente = new Docente("Raul", "111AB");
        Estudiante estudiante = new Estudiante("Esteban", "222B");
        Visitante visitante = new Visitante("Clara", "333B");
        LibroDigital libroDigital = new LibroDigital("Matemáticas generales", "Lucas", 2015, "www.librodigital.com", TipoFormato.PDF);
        LibroReferencia libroReferencia = new LibroReferencia("Libro de Gamer", "Pepe", 2022);
        LibroFisico libroFisico1 = new LibroFisico("Crimen y castigo", "Fiodor", 1925, 200, "Normal", "A22");
        LibroFisico libroFisico2 = new LibroFisico("100 años de soledad", "Gabriel", 1980, 170, "Normal", "A24");
        LibroFisico libroFisico3 = new LibroFisico("La ciudad y los perros", "Andres", 2001, 210, "Caracol", "A24");
        Prestamo prestamo1 = new Prestamo("1A2B", libroFisico1, 2, estudiante, bibliotecario1);
        Prestamo prestamo2 = new Prestamo("2C,3D", libroFisico2, 1, estudiante, bibliotecario1);
        // Agregar empleados
        biblioteca.agregarEmpleado(bibliotecario1);
        biblioteca.agregarEmpleado(admin);
        // Agregar libros
        biblioteca.agregarLibro(libroDigital);
        biblioteca.agregarLibro(libroReferencia);
        biblioteca.agregarLibro(libroFisico1);
        biblioteca.agregarLibro(libroFisico2);
        biblioteca.agregarLibro(libroFisico3);
        biblioteca.agregarPrestamo(prestamo1);
        biblioteca.agregarPrestamo(prestamo2);
        bibliotecario1.agregarPrestamo(biblioteca, prestamo1);
        bibliotecario1.agregarPrestamo(biblioteca, prestamo2);
        // Si tienes listas para estudiantes/docentes/visitantes, agrégalos también si es necesario
        //FALTA AGREGAR LAS COSAS A BIBLIOTECA es decir agregar por medio del crud existente dentro de la biblioteca

    }





}
