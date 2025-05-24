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

    public Administrador(Biblioteca biblioteca, String nombre, String id, String correo, String usuario, String contrasena){
        super(biblioteca, nombre, id , correo,usuario, contrasena);
    }


    @Override
    public StringBuilder generarReporte() {
        return null;
    }

    @Override
    public void agregarEmpleado(Empleado empleado){
        biblioteca.agregarEmpleado(empleado);
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
        ;
    }

}
