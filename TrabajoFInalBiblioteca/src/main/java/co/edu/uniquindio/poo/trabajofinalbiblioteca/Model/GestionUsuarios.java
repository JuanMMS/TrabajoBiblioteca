package co.edu.uniquindio.poo.trabajofinalbiblioteca.Model;

public interface GestionUsuarios {
    public void agregarPersona(Persona persona);
    public String visualizarPersona(Persona persona);
    public void actualizarPersona(Persona persona, String nombre, String id);
    public void eliminarPersona(Persona persona);
}