module com.example.controladorprocesos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.mail;


    opens com.example.controladorprocesos to javafx.fxml;
    exports com.example.controladorprocesos;
    exports com.example.controladorprocesos.controllers;
    opens com.example.controladorprocesos.controllers to javafx.fxml;
}