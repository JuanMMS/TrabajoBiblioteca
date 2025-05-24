package co.edu.uniquindio.poo.trabajofinalbiblioteca.viewController;

import co.edu.uniquindio.poo.trabajofinalbiblioteca.Model.Bibliotecario;
import co.edu.uniquindio.poo.trabajofinalbiblioteca.controller.BibliotecarioController;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class BibliotecarioViewController {

    @FXML
    private TextArea reporteTextArea;

    private BibliotecarioController bibliotecarioController;

    public void initialize() {
        Bibliotecario bibliotecario = new Bibliotecario("Pedro", "123", "pedro@uq.edu.co", "pedro", "1234");
        this.bibliotecarioController = new BibliotecarioController(bibliotecario);
    }

    @FXML
    private void generarReporte() {
        String reporte = bibliotecarioController.generarReporte();
        reporteTextArea.setText(reporte);
    }
}
