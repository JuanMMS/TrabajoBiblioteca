package co.edu.uniquindio.poo.trabajofinalbiblioteca.controller;


import co.edu.uniquindio.poo.trabajofinalbiblioteca.Model.*;
import co.edu.uniquindio.poo.trabajofinalbiblioteca.App;

public class AdministradorController {

    private Administrador administrador;

    public AdministradorController(Administrador administrador) {
        this.administrador = administrador;
    }

    public void agregarEmpleado(Empleado empleado) {
        administrador.agregarEmpleado(App.biblioteca, empleado);
    }

    public void actualizarEmpleado(Empleado empleado, String nombre, String id, String correo) {
        administrador.actualizarEmpleado(App.biblioteca, empleado, nombre, id, correo);
    }

    public void eliminarEmpleado(Empleado empleado) {
        administrador.eliminarEmpleado(App.biblioteca, empleado);
    }
}