package co.edu.uniquindio.poo.trabajofinalbiblioteca.Model;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca{
    private String nombre;
    private String id;
    private String direccion;
    private List<Libro> listLibros;
    private List<Empleado> listEmpleados;
    private List<Persona> listPersonas;


    /**
     * Creación metodo constructor de la clase Biblioteca
     * @param nombre
     * @param id
     * @param direccion
     */
    public Biblioteca(String nombre, String id, String direccion){
        this.nombre = nombre;
        this.id = id;
        this.direccion = direccion;
        this.listLibros = new ArrayList<>();
        this.listEmpleados = new ArrayList<>();
    }

/**
 * CRUD EMPLEADO
 */

    public void agregarEmpleado(Empleado empleado){
        this.listEmpleados.add(empleado);
    }

    public String visualizarEmpleado(Empleado empleado){
        return empleado.toString();
    }

    public void actualizarEmpleado(Empleado empleado, String nombre, String id, String correo){
        empleado.setNombre(nombre);
        empleado.setId(id);
        empleado.setCorreo(correo);
    }

    public void eliminarEmpleado(Empleado empleado){
        listEmpleados.remove(empleado);
    }




    /**
     * CRUD LIBROS
     */

    public void agregarLibro(Libro libro) {
        listLibros.add(libro);
    }
    public String visualizarLibro(Libro libro){
    return libro.toString();
    }
    public void actualizarLibro(Libro libro, String nombre, String autor, int anioPublicacion, boolean disponibilidad){
    libro.setTitulo(nombre);
    libro.setAutor(autor);
    libro.setAnioPublicacion(anioPublicacion);
    libro.setDisponibilidad(disponibilidad);
    }
    public void eliminarEmpleado(Libro libro){
    listLibros.remove(libro);
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
