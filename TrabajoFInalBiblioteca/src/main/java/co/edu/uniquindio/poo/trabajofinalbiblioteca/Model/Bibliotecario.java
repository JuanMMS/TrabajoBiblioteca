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

    public String generarReporteLibrosPrestados() {
            StringBuilder reporte = new StringBuilder();
        for(Prestamo prestamo : getListPrestamosBibliotecario()){
            reporte.append(prestamo.toString()).append("\n");
        }
        return reporte.toString();
    }

}
