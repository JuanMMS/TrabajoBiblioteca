module co.edu.uniquindio.poo.trabajofinalbiblioteca {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.uniquindio.poo.trabajofinalbiblioteca.viewController to javafx.fxml;
    opens co.edu.uniquindio.poo.trabajofinalbiblioteca.controller to javafx.fxml;

    exports co.edu.uniquindio.poo.trabajofinalbiblioteca;
    exports co.edu.uniquindio.poo.trabajofinalbiblioteca.viewController;
    exports co.edu.uniquindio.poo.trabajofinalbiblioteca.controller;
}