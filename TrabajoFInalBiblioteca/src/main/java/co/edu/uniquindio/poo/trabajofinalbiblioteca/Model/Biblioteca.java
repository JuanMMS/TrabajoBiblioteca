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
    private List<Prestamo> listPrestamos;
    private Empleado empleadoActual;

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
        this.listPersonas = new ArrayList<>();
        this.listPrestamos = new ArrayList<>();
    }


    /**
     * CRUD PERSONA
     */
    public void agregarPersona(Persona persona){
        listPersonas.add(persona);
    }
    public String visualizarPersona(Persona persona){
        return persona.toString();
    }
    public void actualizarPersona(Persona persona, String nombre, String id){
        persona.setNombre(nombre);
        persona.setId(id);
        listPersonas.add(persona);
    }
    public void eliminarPersona(Persona persona){
        listPersonas.remove(persona);
    }

    public Persona buscarPersona(String nombre) {
        for (Persona persona : listPersonas) {
            if (persona.getNombre().equalsIgnoreCase(nombre)) {
                return persona;
            }
        }
        return null;
    }
    public Persona buscarPersonaPorId(String id) {
        for (Persona persona : listPersonas) {
            if (persona.getId().equals(id)) {
                return persona;
            }
        }
        return null; // Si no se encuentra, retorna null
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
     * Metodo para agregar prestamo
     */
    public void agregarPrestamo(Prestamo prestamo) {
        listPrestamos.add(prestamo);
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

    public List<Persona> getListPersonas() {
        return listPersonas;
    }

    public void setListPersonas(List<Persona> listPersonas) {
        this.listPersonas = listPersonas;
    }

    public List<Prestamo> getListPrestamos() {
        return listPrestamos;
    }

    public void setListPrestamos(List<Prestamo> listPrestamos) {
        this.listPrestamos = listPrestamos;
    }


    public Empleado getEmpleadoActual() {
        return empleadoActual;
    }

    public void setEmpleadoActual(Empleado empleadoActual) {
        this.empleadoActual = empleadoActual;
    }

}
