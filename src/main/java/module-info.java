module com.hospital {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.hospital to javafx.fxml;
    exports com.hospital;
}
