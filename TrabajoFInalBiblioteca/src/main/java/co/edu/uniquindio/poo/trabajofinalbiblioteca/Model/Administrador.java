package co.edu.uniquindio.poo.trabajofinalbiblioteca.Model;

public class Administrador extends Empleado {

    /**
     * Creación del método constructor de la clase administrador
     * @param nombre
     * @param id
     * @param correo
     * @param usuario
     * @param contrasena
     */
    public Administrador(String nombre, String id, String correo, String usuario, String contrasena){
        super(nombre, id , correo,usuario, contrasena);
    }

}
