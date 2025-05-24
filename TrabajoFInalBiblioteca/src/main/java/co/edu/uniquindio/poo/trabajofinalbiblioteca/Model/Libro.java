
package co.edu.uniquindio.poo.trabajofinalbiblioteca.Model;

public class Libro {
    protected String nombre;
    protected String autor;
    protected int anioPublicacion;
    protected boolean disponibilidad;
    private Prestamo thePrestamoLibro;

    /**
     * Metodo constructor de la clase padre Libro
     * @param nombre
     * @param autor
     * @param anioPublicacion
     * @param disponibilidad
     */
    public Libro(String nombre, String autor, int anioPublicacion) {
        this.nombre = nombre;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.disponibilidad = true;
    }

    /**
     * Metodos getter y setter de la clase padre Libro
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Prestamo getThePrestamoLibro() {
        return thePrestamoLibro;
    }

    public void setThePrestamoLibro(Prestamo thePrestamoLibro) {
        this.thePrestamoLibro = thePrestamoLibro;
    }
}

