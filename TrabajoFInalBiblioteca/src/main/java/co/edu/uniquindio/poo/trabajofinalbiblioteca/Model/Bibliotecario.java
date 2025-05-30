package co.edu.uniquindio.poo.trabajofinalbiblioteca.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Bibliotecario(String nombre, String id, String correo, String usuario, String contrasena) {
        super(nombre, id, correo, usuario, contrasena);
        this.listPrestamosBibliotecario = new ArrayList<>();
    }

    /**
     * Metodo de bibliotecario para generar reportes
     * @return
     */
    public String generarReporte() {
        String reporte = "Reporte de préstamos de " + getNombre() + ":\n";
        if (listPrestamosBibliotecario == null || listPrestamosBibliotecario.isEmpty()) {
            return "No se encontraron préstamos.";
        }

        for (Prestamo prestamo : listPrestamosBibliotecario) {
            Libro libro = prestamo.getLibro();
            reporte += "ID Prestamo: " + prestamo.getId() + "\nTitulo del libro prestado: "+ libro.getTitulo() + "\nPersona a quien se presta: " + prestamo.getPersona().getNombre() + "\nEstado del libro: " + stringDisponibilidad(prestamo.isDevuelto()) + "\n\n";
        }
        reporte += "\n\nLista de personas con deuda:\n";
        reporte += nombrePersonasConDeuda() + "\n\n";
        reporte += libroMasPrestado();

        return reporte;
    }

    /**
     * Método para verificar disponibilidad del libro.
     * @param disponibilidad
     * @return
     */
    public String stringDisponibilidad(boolean disponibilidad) {
        String disponibilidadString = "";
        if(disponibilidad) {
            disponibilidadString = "Devuelto";
        }
        else {
            disponibilidadString = "Pendiente devolución";
        }
        return disponibilidadString;
    }


    /**
     * Método para obtener el libro más prestado de bibliotecario
     * @return
     */
    public String libroMasPrestado() {
        if (listPrestamosBibliotecario == null || listPrestamosBibliotecario.isEmpty()) {
            return "No se encontraron préstamos.";
        }

        // Mapa para contar cuántas veces ha sido prestado cada libro
        Map<String, Integer> contadorPrestamos = new HashMap<>();

        for (Prestamo prestamo : listPrestamosBibliotecario) {
            String titulo = prestamo.getLibro().getTitulo();
            contadorPrestamos.put(titulo, contadorPrestamos.getOrDefault(titulo, 0) + 1);
        }

        String libroMasPrestado = null;
        int maxPrestamos = 0;

        for (Map.Entry<String, Integer> entry : contadorPrestamos.entrySet()) {
            if (entry.getValue() > maxPrestamos) {
                libroMasPrestado = entry.getKey();
                maxPrestamos = entry.getValue();
            }
        }
        return "Libro más prestado: " + libroMasPrestado + " (" + maxPrestamos + " veces)";
    }

    /**
     * Método para obtener la lista de personas que tienen deuda (no han devuelto el libro)
     * @return
     */
    public List<Persona> listPersonasConDeuda() {
        List<Persona> listPersonasConDeuda = new ArrayList<>();
        for (Prestamo prestamo : listPrestamosBibliotecario) {
            Persona persona = prestamo.getPersona();
            if (!prestamo.isDevuelto() && !listPersonasConDeuda.contains(persona)) {
                listPersonasConDeuda.add(persona);
            }
        }
        return listPersonasConDeuda;
    }

    /**
     * Método para obtener una lista de nombres de las personas que tienen deuda.
     * @return
     */
    public String nombrePersonasConDeuda() {
        String listPersonasConDeuda = "";
        List<Persona> listPersonas = listPersonasConDeuda();
        for(Persona persona : listPersonas){
            listPersonasConDeuda += persona.getNombre() + "\n";
        }
        return listPersonasConDeuda;
    }

    /**
     * Metodo para agregar un libro a la biblioteca
     */

    public void agregarLibro(Biblioteca biblioteca, Libro libro) {
        biblioteca.agregarLibro(libro);
    }
    /**
     * Metodo para devolver un libro prestado
     */

    public void devolverLibro(Prestamo prestamo) {
        prestamo.devolverLibro();
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

    public List<Prestamo> getListPrestamosBibliotecario() {
        return listPrestamosBibliotecario;
    }
    public void setListPrestamosBibliotecario(List<Prestamo> listPrestamosBibliotecario) {
        this.listPrestamosBibliotecario = listPrestamosBibliotecario;
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


}

