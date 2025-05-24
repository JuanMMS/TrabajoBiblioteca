package co.edu.uniquindio.poo.trabajofinalbiblioteca.Model;

import java.util.ArrayList;
import java.util.List;

public abstract class Empleado {
    private String nombre;
    private String id;
    private String correo;
    private String usuario;
    private String contrasenia;
    private List<Prestamo> listPrestamosBibliotecario;


    /**
     * Método constructor de la clase Empleado
     * @param nombre
     * @param id
     * @param correo
     * @param usuario
     * @param contrasenia
     */
    public Empleado(String nombre, String id, String correo, String usuario, String contrasenia) {
        this.nombre = nombre;
        this.id = id;
        this.correo = correo;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.listPrestamosBibliotecario = new ArrayList<>();
    }


    /**
     * Metodo de autenticacion
     */
    public boolean validarCredenciales(String usuario, String contrasenia) {
        return this.usuario.equals(usuario) && this.contrasenia.equals(contrasenia);
    }
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

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasena) {
        this.contrasenia = contrasenia;
    }

    public List<Prestamo> getListPrestamosBibliotecario() {return listPrestamosBibliotecario;}

    public void setListPrestamosBibliotecario(List<Prestamo> listPrestamosBibliotecario) {this.listPrestamosBibliotecario = listPrestamosBibliotecario;}
}
