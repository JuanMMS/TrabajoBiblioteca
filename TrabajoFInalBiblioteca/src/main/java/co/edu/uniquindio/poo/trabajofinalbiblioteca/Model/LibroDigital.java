package co.edu.uniquindio.poo.trabajofinalbiblioteca.Model;

public class LibroDigital extends Libro {

    private String linkDescarga;
    private TipoFormato tipoFormato;


    /**
     * Metodo constructor de la clase hija LibroDigital
     * @param nombre
     * @param autor
     * @param anioPublicacion
     * @param linkDescarga
     * @param tipoFormato
     */
    public LibroDigital(String nombre, String autor, int anioPublicacion, String linkDescarga, TipoFormato tipoFormato) {
        super(nombre, autor, anioPublicacion);
        this.linkDescarga = linkDescarga;
        this.tipoFormato = tipoFormato;
    }

    /**
     * Metodos getter y setter de los atributos propios de la clase hija LibroDigital
     * @return
     */
    public String getLinkDescarga() {
        return linkDescarga;
    }

    public void setLinkDescarga(String linkDescarga) {
        this.linkDescarga = linkDescarga;
    }

    public TipoFormato getTipoFormato() {
        return tipoFormato;
    }

    public void setTipoFormato(TipoFormato tipoFormato) {
        this.tipoFormato = tipoFormato;
    }
}
