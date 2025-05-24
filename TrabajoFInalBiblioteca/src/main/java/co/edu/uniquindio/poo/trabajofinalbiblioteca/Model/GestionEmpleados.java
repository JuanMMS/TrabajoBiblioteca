package co.edu.uniquindio.poo.trabajofinalbiblioteca.Model;

public interface GestionEmpleados {

    public void agregarEmpleado(Biblioteca biblioteca, Empleado empleado);
    public String visualizarEmpleado(Empleado empleado);
    public void actualizarEmpleado(Empleado empleado, String nombre, String id, String correo);
    public void eliminarEmpleado(Empleado empleado);
}
