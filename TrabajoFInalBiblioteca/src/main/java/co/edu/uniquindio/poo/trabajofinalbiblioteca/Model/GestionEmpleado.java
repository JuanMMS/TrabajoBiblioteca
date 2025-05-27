package co.edu.uniquindio.poo.trabajofinalbiblioteca.Model;

public interface GestionEmpleado {

    public void agregarEmpleado(Biblioteca biblioteca, Empleado empleado);
    public String visualizarEmpleado(Biblioteca biblioteca, Empleado empleado);
    public void actualizarEmpleado(Biblioteca biblioteca, Empleado empleado, String nombre, String id, String correo);
    public void eliminarEmpleado(Biblioteca biblioteca, Empleado empleado);
}
