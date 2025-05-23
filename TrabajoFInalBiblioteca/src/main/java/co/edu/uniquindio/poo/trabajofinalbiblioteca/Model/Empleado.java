package co.edu.uniquindio.poo.trabajofinalbiblioteca.Model;

import java.util.ArrayList;
import java.util.List;

public abstract class Empleado {
    private Biblioteca biblioteca;
    private String nombre;
    private String id;
    private String correo;
    private String usuario;
    private String contrasena;
    private List<Prestamo> listPrestamosBibliotecario;


    /**
     * Método constructor de la clase Empleado
     * @param biblioteca
     * @param nombre
     * @param id
     * @param correo
     * @param usuario
     * @param contrasena
     */
    public Empleado(Biblioteca biblioteca, String nombre, String id, String correo, String usuario, String contrasena) {
        this.biblioteca = biblioteca;
        this.nombre = nombre;
        this.id = id;
        this.correo = correo;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.listPrestamosBibliotecario = new ArrayList<>();
    }

    public abstract String generarReporte();

    /**
     * Creación de los métodos getter y setter de losatributos de la clase Empleado
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<Prestamo> getListPrestamosBibliotecario() {return listPrestamosBibliotecario;}

    public void setListPrestamosBibliotecario(List<Prestamo> listPrestamosBibliotecario) {this.listPrestamosBibliotecario = listPrestamosBibliotecario;}
}
