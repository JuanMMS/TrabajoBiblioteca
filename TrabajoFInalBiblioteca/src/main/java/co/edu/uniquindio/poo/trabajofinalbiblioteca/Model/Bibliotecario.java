package co.edu.uniquindio.poo.trabajofinalbiblioteca.Model;

import java.util.ArrayList;
import java.util.List;

public class Bibliotecario extends Empleado {
    private List<Prestamo> listPrestamosBibliotecario;
    /**
     * Creación del método constructor de la clase Bibliotecario
     * @param nombre
     * @param id
     * @param correo
     * @param usuario
     * @param contrasena
     */
    public Bibliotecario(Biblioteca biblioteca, String nombre, String id, String correo, String usuario, String contrasena){
        super(biblioteca, nombre, id, correo,usuario, contrasena);
        this.listPrestamosBibliotecario = new ArrayList<>();
    }

    /**
     * Metodo que genera un reporte de los libros prestados por bibliotecario
     * @return
     */
    public String generarReporte() {
            StringBuilder reporte = new StringBuilder();
        for(Prestamo prestamo : getListPrestamosBibliotecario()){
            reporte.append(prestamo.toString()).append("\n");
        }
        return reporte.toString();
    }

    /**
     * Método para agregar prestamo a la lista "listPrestamosBibliotecario"
     * @param prestamo
     */
    public void agregarPrestamo(Prestamo prestamo){
        listPrestamosBibliotecario.add(prestamo);
    }

    /**
     * Creación de los método getter y setter de listPrestamosBibliotecario
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
