package co.edu.uniquindio.poo.trabajofinalbiblioteca.Model;

public class Persona {
    private String nombre;
    private String id;
    private Prestamo thePrestamo;

    public Persona(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.thePrestamo = null;
    }

    /**
     * Creación de los métodos getter y setter de la clase Persona
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Prestamo getThePrestamo() {
        return thePrestamo;
    }

    public void setThePrestamo(Prestamo thePrestamo) {
        this.thePrestamo = thePrestamo;
    }
}
