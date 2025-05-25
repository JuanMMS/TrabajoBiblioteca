package co.edu.uniquindio.poo.trabajofinalbiblioteca.controller;

import co.edu.uniquindio.poo.trabajofinalbiblioteca.Model.Empleado;

import java.util.ArrayList;
import java.util.List;

public class LoginController {

    private List<Empleado> listaEmpleados = new ArrayList<>();

    public void setListaEmpleados(List<Empleado> empleados) {
        this.listaEmpleados = empleados;
    }

    public Empleado autenticar(String usuario, String contrasenia, String rolSeleccionado) {
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getClass().getSimpleName().equalsIgnoreCase(rolSeleccionado)
                    && empleado.validarCredenciales(usuario, contrasenia)) {
                return empleado;
            }
        }
        return null;
    }
}