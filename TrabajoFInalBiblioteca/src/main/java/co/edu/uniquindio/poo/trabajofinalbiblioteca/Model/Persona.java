package co.edu.uniquindio.poo.trabajofinalbiblioteca.Model;

import java.util.List;

public class Persona {
    private String nombre;
    private String id;
    private List<Prestamo> listPrestamosPersona;

    public Persona(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.listPrestamosPersona = null;
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

    public List<Prestamo> getListPrestamosPersona() {
        return listPrestamosPersona;
    }

    public void setListPrestamosPersona(List<Prestamo> listPrestamosPersona) {
        this.listPrestamosPersona = listPrestamosPersona;
    }
}
