package co.edu.uniquindio.poo.trabajofinalbiblioteca.Model;

public class LibroFisico extends Libro {

    private int numeroPaginas;
    private String editorial;
    private String ubicacion;

    /**
     * Metodo constructor de la clase hija LibroFisico
     * @param nombre
     * @param autor
     * @param anioPublicacion
     * @param numeroPaginas
     * @param editorial
     * @param ubicacion
     */
    public LibroFisico(String nombre, String autor, int anioPublicacion, int numeroPaginas, String editorial, String ubicacion) {
        super(nombre, autor, anioPublicacion);
        this.numeroPaginas = numeroPaginas;
        this.editorial = editorial;
        this.ubicacion = ubicacion;

    }

    /**
     * Metodos getter y setter de los atributos propios de la clase hija libro fisico
     * @return
     */
    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }


}
