
package co.edu.uniquindio.poo.trabajofinalbiblioteca.Model;

public class Libro {
    protected String titulo;
    protected String autor;
    protected int anioPublicacion;
    protected boolean disponibilidad;
    private Prestamo thePrestamoLibro;

    /**
     * Metodo constructor de la clase padre Libro
     * @param Titulo
     * @param autor
     * @param anioPublicacion
     */
    public Libro(String titulo, String autor, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.disponibilidad = true;
    }

    /**
     * Metodos getter y setter de la clase padre Libro
     * @return
     */
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String nombre) {
        this.titulo = nombre;
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

    @Override
    public String toString() {
        return "Libro{" +
                "Titulo='" + titulo + ", Autor='" + autor;
    }
}

