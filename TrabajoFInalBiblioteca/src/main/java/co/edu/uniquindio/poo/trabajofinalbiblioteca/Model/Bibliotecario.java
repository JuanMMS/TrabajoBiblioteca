package co.edu.uniquindio.poo.trabajofinalbiblioteca.Model;

import java.util.ArrayList;
import java.util.List;

public class Bibliotecario extends Empleado implements GestionLibro{
    private List<Prestamo> listPrestamosBibliotecario;

    /**
     * Creación del método constructor de la clase Bibliotecario
     * @param nombre
     * @param id
     * @param correo
     * @param usuario
     * @param contrasena
     */
    public Bibliotecario(String nombre, String id, String correo, String usuario, String contrasena) {
        super(nombre, id, correo, usuario, contrasena);
        this.listPrestamosBibliotecario = new ArrayList<>();
    }

    /**
     * Metodo para agregar un libro a la biblioteca
     */
    @Override
    public void agregarLibro(Biblioteca biblioteca, Libro libro) {
        biblioteca.agregarLibro(libro);


    }
    /**
     * Metodo para devolver un libro prestado
     */
    @Override
    public void devolverLibro(Prestamo prestamo) {
        prestamo.devolverLibro();
    }

    /**
     * Metodo de bibliotecario para generar reportes
     * @return
     */
    public String generarReporte() {
        String reporte = "Reporte de préstamos de " + getNombre() + ":\n";
        LibroFisico libroMasPrestado = null;
        List<Persona> listUsuariosConDeuda = new ArrayList<>();

        for (Prestamo prestamo : listPrestamosBibliotecario) {
            reporte += prestamo.toString() + "\n";

            // Obtener el libro más prestado por el bibliotecario
            if (prestamo.getLibro() instanceof LibroFisico) {
                LibroFisico libro = (LibroFisico) prestamo.getLibro();
                if (libroMasPrestado == null || libro.getVecesPrestado() > libroMasPrestado.getVecesPrestado()) {
                    libroMasPrestado = libro;
                }
            }
            // Agregar personas con deuda por tener libros prestados
            Persona persona = prestamo.getPersona();
            if (!prestamo.isDevuelto() && !listUsuariosConDeuda.contains(persona)) {
                listUsuariosConDeuda.add(persona);
            }
        }

        if (libroMasPrestado != null) {
            reporte += "\nLibro más prestado: " + libroMasPrestado.getTitulo() +
                    " (" + libroMasPrestado.getVecesPrestado() + " veces)\n";
        } else {
            reporte += "\nNo se encontraron préstamos.\n";
        }
        reporte += "\nUsuarios con deudas:\n";
        if (listUsuariosConDeuda.isEmpty()) {
            reporte += "- No hay usuarios con deudas.\n";
        } else {
            for (Persona persona : listUsuariosConDeuda) {
                reporte += "- " + persona.getNombre() + "\n";
            }
        }
        return reporte;
    }

    /**
    *Metodos para la gestion de Personas que recurren la biblioteca
     * @param biblioteca
     */
    public void agregarPersona(Biblioteca biblioteca, Persona persona){
        biblioteca.agregarPersona(persona);
    }
    public String visualizarPersona(Biblioteca biblioteca, Persona persona){
        return biblioteca.visualizarPersona(persona);
        }
    public void actualizarPersona(Biblioteca biblioteca, Persona persona, String nombre, String id){
        biblioteca.actualizarPersona(persona, nombre, id);
    }
    public void eliminarPersona(Biblioteca biblioteca, Persona persona){
        biblioteca.eliminarPersona(persona);
    }


    /**
     * Metodo para agregar preestamo
     * @param biblioteca
     * @param prestamo
     */
    public void agregarPrestamo(Biblioteca biblioteca, Prestamo prestamo){
        listPrestamosBibliotecario.add(prestamo);
        biblioteca.agregarPrestamo(prestamo);
    }
    /**
     * Creación método getter y setter para el atributo "listPrestamosBlibliotecario"
     * @return
     */

    @Override
    public List<Prestamo> getListPrestamosBibliotecario() {
        return listPrestamosBibliotecario;
    }

    @Override
    public void setListPrestamosBibliotecario(List<Prestamo> listPrestamosBibliotecario) {
        this.listPrestamosBibliotecario = listPrestamosBibliotecario;
    }


}

