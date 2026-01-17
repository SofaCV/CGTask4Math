module com.cgvsu {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;


    opens com.cgvsu to javafx.fxml;
    exports com.cgvsu;
}