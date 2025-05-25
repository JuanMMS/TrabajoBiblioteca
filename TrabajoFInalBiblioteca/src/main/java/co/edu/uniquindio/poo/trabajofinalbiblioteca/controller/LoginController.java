package co.edu.uniquindio.poo.trabajofinalbiblioteca.controller;

import co.edu.uniquindio.poo.trabajofinalbiblioteca.Model.Empleado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class LoginController {

    @FXML
    private TextField usuarioField;

    @FXML
    private PasswordField contraseniaField;

    @FXML
    private RadioButton adminRadioBtn;

    @FXML
    private RadioButton bibliotecarioRadioBtn;

    @FXML
    private ToggleGroup rolGroup;

    private List<Empleado> listaEmpleados = new ArrayList<>();

    public LoginController() {
        // Constructor vacío requerido por FXMLLoader
    }

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

    @FXML
    public void ingresar(ActionEvent actionEvent) {
        String usuario = usuarioField.getText();
        String contrasenia = contraseniaField.getText();

        String rol = null;
        if (adminRadioBtn.isSelected()) {
            rol = "Administrador";
        } else if (bibliotecarioRadioBtn.isSelected()) {
            rol = "Bibliotecario";
        } else {
            System.out.println("Selecciona un rol");
            return;
        }

        Empleado empleado = autenticar(usuario, contrasenia, rol);
        if (empleado != null) {
            System.out.println("Autenticado: " + empleado.getNombre());
            // Aquí puedes redirigir a otra vista según el rol
        } else {
            System.out.println("Credenciales incorrectas");
        }
    }
}
