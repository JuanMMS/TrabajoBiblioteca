module co.edu.uniquindio.poo.trabajofinalbiblioteca {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.trabajofinalbiblioteca to javafx.fxml;
    exports co.edu.uniquindio.poo.trabajofinalbiblioteca;
}