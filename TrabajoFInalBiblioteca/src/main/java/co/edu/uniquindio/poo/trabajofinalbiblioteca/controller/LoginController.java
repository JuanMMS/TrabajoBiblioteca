package co.edu.uniquindio.poo.trabajofinalbiblioteca.controller;

import co.edu.uniquindio.poo.trabajofinalbiblioteca.Model.Empleado;
import javafx.event.ActionEvent;

import java.util.List;

public class LoginController {

    private final List<Empleado> listaEmpleados;

    public LoginController(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
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

    public void ingresar(ActionEvent actionEvent) {
    }
}
