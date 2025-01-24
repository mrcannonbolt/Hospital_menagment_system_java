module com.hospital {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.base;

    opens com.hospital to javafx.fxml;
    exports com.hospital;
}
