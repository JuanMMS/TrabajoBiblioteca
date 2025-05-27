package co.edu.uniquindio.poo.trabajofinalbiblioteca.Model;

public class Administrador extends Empleado  {

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


    public String generarReporte(Bibliotecario bibliotecario) {
        String reporte = "";
        reporte += "Reporte del completo bibliotecario:\n";
        reporte += bibliotecario.generarReporte();
        return reporte;
    }

    /**
     * Metodos CRUD de empleado por medio de la biblioteca
     * @param biblioteca
     * @param empleado
     */

    public void agregarEmpleado(Biblioteca biblioteca, Empleado empleado){
        biblioteca.agregarEmpleado(empleado);
    }


    public String visualizarEmpleado(Biblioteca biblioteca, Empleado empleado){
        return empleado.toString();
    }

    public void actualizarEmpleado(Biblioteca biblioteca, Empleado empleado, String nombre, String id, String correo){
        empleado.setNombre(nombre);
        empleado.setId(id);
        empleado.setCorreo(correo);
    }

    public void eliminarEmpleado(Biblioteca biblioteca, Empleado empleado){
        biblioteca.getListEmpleados().remove(empleado);
    }

}
