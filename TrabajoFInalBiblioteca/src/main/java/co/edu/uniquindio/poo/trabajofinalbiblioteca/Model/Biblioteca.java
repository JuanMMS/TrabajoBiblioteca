package co.edu.uniquindio.poo.trabajofinalbiblioteca.Model;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nombre;
    private String id;
    private String direccion;
    private List<Libro> listLibros;
    private List<Empleado> listEmpleados;

    /**
     * Creación metodo constructor de la clase Biblioteca
     * @param nobre
     * @param id
     * @param direccion
     */
    public Biblioteca(String nobre, String id, String direccion){
        this.nombre = nobre;
        this.id = id;
        this.direccion = direccion;
        this.listLibros = new ArrayList<>();
        this.listEmpleados = new ArrayList<>();
    }

    /**
     * Creación de métodos getter y setters de los metodos de Biblioteca
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Libro> getListLibros() {
        return listLibros;
    }

    public void setListLibros(List<Libro> listLibros) {
        this.listLibros = listLibros;
    }

    public List<Empleado> getListEmpleados() {
        return listEmpleados;
    }

    public void setListEmpleados(List<Empleado> listEmpleados) {
        this.listEmpleados = listEmpleados;
    }
}
