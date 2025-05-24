package co.edu.uniquindio.poo.trabajofinalbiblioteca.Model;

import java.util.ArrayList;
import java.util.List;

public class Bibliotecario extends Empleado {
    private List<Prestamo> listPrestamosBibliotecario;

    /**
     * Creación del método constructor de la clase Bibliotecario
     *
     * @param nombre
     * @param id
     * @param correo
     * @param usuario
     * @param contrasena
     */
    public Bibliotecario(Biblioteca biblioteca, String nombre, String id, String correo, String usuario, String contrasena) {
        super(biblioteca, nombre, id, correo, usuario, contrasena);
        this.listPrestamosBibliotecario = new ArrayList<>();
    }

    public String generarReporte(){
        String reporte = "Reporte de prestamos de "+ getNombre() +":\n";
        for(Prestamo prestamo : listPrestamosBibliotecario){
            reporte += prestamo.toString();
        }
        return reporte;

    }

    /**
     * Método para agregar prestamo a la lista de prestamos del bibliotecario
     * @param prestamo
     */
    public void agregarPrestamo(Prestamo prestamo){
        listPrestamosBibliotecario.add(prestamo);
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

