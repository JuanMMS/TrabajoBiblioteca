package co.edu.uniquindio.poo.trabajofinalbiblioteca.Model;

public class LibroReferencia extends Libro {


    /**
     * Creación metodo consutructor de la clase Libro Referencia
     * @param titulo
     * @param autor
     * @param anioPublicacion
     */
    public LibroReferencia(String titulo, String autor, int anioPublicacion) {
        super(titulo, autor, anioPublicacion);
        this.disponibilidad = false;


        
    }
}
