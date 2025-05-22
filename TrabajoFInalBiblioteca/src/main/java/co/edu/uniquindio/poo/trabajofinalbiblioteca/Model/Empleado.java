package co.edu.uniquindio.poo.trabajofinalbiblioteca.Model;

public class Empleado {
    private String nombre;
    private String id;
    private String correo;
    private String usuario;
    private String contrasena;

    public Empleado(String nombre, String id, String correo, String usuario, String contrasena) {
        this.nombre = nombre;
        this.id = id;
        this.correo = correo;
        this.usuario = usuario;
        this.contrasena = contrasena;
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
