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
            Libro libro = prestamo.getLibro();
            reporte += "ID Prestamo: " + prestamo.getId() + "\nTitulo del libro prestado: "+ libro.getTitulo() + "\nPersona a quien se presta: " + prestamo.getPersona().getNombre() + "\nPendiente devolver: " + prestamo.isDevuelto() + "\n";
        }
        reporte += "\n\nLista de personas con deuda:\n";
        reporte += nombrePersonasConDeuda() + "\n";
        /**if (libroMasPrestado != null) {
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
        }*/
        return reporte;
    }

    /**
     * Método para obtener el libro más prestado de bibliotecario
     * @return
     */
   /** public String libroMasPrestado(){
        Libro libroMasPrestado = null;
        String tituloMasPrestado = "";
        for(Prestamo prestamo : listPrestamosBibliotecario){
            if(libroMasPrestado != null) {
                tituloMasPrestado += "\nLibro más prestado: " + libroMasPrestado.getTitulo() +
                        " (" + libroMasPrestado.getVecesPrestado() + " veces)\n";
            } else {
                tituloMasPrestado += "\nNo se encontraron préstamos.\n";
            }
            tituloMasPrestado += "\nUsuarios con deudas:\n";
            if (listUsuariosConDeuda.isEmpty()) {
                tituloMasPrestado += "- No hay usuarios con deudas.\n";
            } else {
                for (Persona persona : listUsuariosConDeuda) {
                    tituloMasPrestado += "- " + persona.getNombre() + "\n";
                }
            }

        }

    }
    /*

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
    @Override
    public List<Prestamo> getListPrestamosBibliotecario() {
        return listPrestamosBibliotecario;
    }
    @Override
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

