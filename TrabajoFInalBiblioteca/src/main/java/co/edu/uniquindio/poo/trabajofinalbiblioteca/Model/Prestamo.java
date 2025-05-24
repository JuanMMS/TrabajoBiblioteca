package co.edu.uniquindio.poo.trabajofinalbiblioteca.Model;

public class Prestamo   {
    private String id;
    private Libro libro;
    private int duracion;
    private Persona persona;
    private Bibliotecario bibliotecario;
    private boolean devuelto;


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
        this.devuelto = false;
    }


    /**
     * Metodo de devolucion de prestamo
     */
    public void devolverLibro(){
        this.devuelto = true;
    }

    /**
     * Creación métodos Getter y Setter de la clase Prestamo
     * @return
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "id='" + id + '\'' +
                ", libro=" + libro +
                ", duracion=" + duracion +
                ", persona=" + persona +
                ", bibliotecario=" + bibliotecario +
                ", devuelto=" + devuelto +
                '}' + "\n";
    }
}
