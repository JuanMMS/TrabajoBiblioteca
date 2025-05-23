package co.edu.uniquindio.poo.trabajofinalbiblioteca.Model;

public interface GestionUsuarios {
    public void agregarPersona(Persona persona);
    public String visualizarEmpleado(Persona persona);
    public void actualizarEmpleado(Persona persona, String nombre, String id);
    public void eliminarEmpleado(Persona persona);
}
