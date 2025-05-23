package co.edu.uniquindio.poo.trabajofinalbiblioteca.Model;

public class Administrador extends Empleado implements GestionEmpleados {

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

    @Override
    public void agregarEmpleado(Biblioteca biblioteca, Empleado empleado){
        biblioteca.getListEmpleados;
    }

    @Override
    public String visualizarEmpleado(Empleado empleado){
        return empleado.toString();
    }
    @Override
    public void actualizarEmpleado(Empleado empleado, String nombre, String id, String correo){
        empleado.setNombre(nombre);
        empleado.setId(id);
        empleado.setCorreo(correo);
    }
    @Override
    public void eliminarEmpleado(Empleado empleado){
        listEmpleados.remove(empleado);
    }

}
