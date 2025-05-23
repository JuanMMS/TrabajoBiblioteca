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


    /**
     * Metodo que genera un reporte de los libros prestados por bibliotecario, usuario con deuda y libros mas prestados
     *
     * @return
     */


    public void obtenerListPrestamosBibliotecario() {
        StringBuilder listPrestamos = new StringBuilder();
        for (Prestamo prestamo : getListPrestamosBibliotecario()) {
            listPrestamos.append(prestamo.toString()).append("\n");
        }
    }

    public String obtenerLibrosMasPrestados() {
        List<Libro> librosContados = new ArrayList<>();
        List<Integer> cantidades = new ArrayList<>();

        for (Prestamo prestamo : getListPrestamosBibliotecario()) {
            Libro libro = prestamo.getLibro();
            boolean encontrado = false;

            for (int i = 0; i < librosContados.size(); i++) {
                if (librosContados.get(i).equals(libro)) {
                    cantidades.set(i, cantidades.get(i) + 1);
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                librosContados.add(libro);
                cantidades.add(1);
            }
        }

        // Ordenar por cantidad (burbuja descendente)
        for (int i = 0; i < cantidades.size() - 1; i++) {
            for (int j = i + 1; j < cantidades.size(); j++) {
                if (cantidades.get(j) > cantidades.get(i)) {
                    int tempCant = cantidades.get(i);
                    cantidades.set(i, cantidades.get(j));
                    cantidades.set(j, tempCant);

                    Libro tempLibro = librosContados.get(i);
                    librosContados.set(i, librosContados.get(j));
                    librosContados.set(j, tempLibro);
                }
            }
        }

        StringBuilder resultado = new StringBuilder();
        resultado.append("\n=== Libros más prestados ===\n");

        if (librosContados.isEmpty()) {
            resultado.append("No hay libros prestados aún.\n");
        } else {
            for (int i = 0; i < Math.min(4, librosContados.size()); i++) {
                resultado.append((i + 1)).append(". ")
                        .append(librosContados.get(i).getNombre())
                        .append(" - Veces prestado: ")
                        .append(cantidades.get(i)).append("\n");
            }
        }

        return resultado.toString();
    }

    @Override
    public StringBuilder generarReporte() {
        StringBuilder reporte = new StringBuilder();

        reporte.append("=== Resumen de préstamos de ").append(getNombre()).append(" ===\n\n");

        if (listPrestamosBibliotecario.isEmpty()) {
            reporte.append("No hay préstamos registrados.\n");
        } else {
            reporte.append("Listado de préstamos:\n");
            for (Prestamo prestamo : listPrestamosBibliotecario) {
                reporte.append("- ").append(prestamo.toString()).append("\n");
            }
        }

        reporte.append("\n").append(obtenerLibrosMasPrestados());

        return reporte;
    }
}
