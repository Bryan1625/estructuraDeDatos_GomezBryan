module com.colecciones.laboratoriocolecciones {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.colecciones.laboratoriocolecciones to javafx.fxml;

    // Exporta el paquete principal de la aplicación
    exports com.colecciones.laboratoriocolecciones;
}
