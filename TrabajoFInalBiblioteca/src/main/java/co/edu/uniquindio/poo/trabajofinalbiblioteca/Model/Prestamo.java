package co.edu.uniquindio.poo.trabajofinalbiblioteca.Model;

public class Prestamo {
    private String id;
    private Libro libro;
    private int duracion;
    private Persona persona;
    private Bibliotecario bibliotecario;


    /**
     * Metodo constructor de la clase Prestamo
     * @param id
     * @param libro
     * @param duracion
     * @param persona
     * @param bibliotecario
     */
    public Prestamo(String id, Libro libro, int duracion, Persona persona, Bibliotecario bibliotecario) {
        this.id = id;
        this.libro = libro;
        this.duracion = duracion;
        this.persona = persona;
        this.bibliotecario = bibliotecario;
    }


}
