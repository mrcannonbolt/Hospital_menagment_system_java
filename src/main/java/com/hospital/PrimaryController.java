package com.hospital;

import java.io.IOException;
import com.hospital.Staff_and_patients.Terminal;

import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void openTerminal() throws IOException {
        Terminal terminal = new Terminal();
        terminal.show();
    }
}
