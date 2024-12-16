package com.hospital;

import java.io.IOException;
import com.hospital.Staff_and_patients.Terminal;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;

public class TerminalController
{

    @FXML
    public final enterPress( button)
    {
    KeyEvent event -> {
        switch (event.getCode()) 
        {
            case ENTER:
                String command = terminal.getText().trim(); // Pobierz komendę
                terminal.appendText("\n> " + processCommand(command)); // Wyświetl wynik
                terminal.setScrollTop(Double.MAX_VALUE); // Przewijanie na dół
                event.consume(); // Zablokuj nową linię w TextArea
                break;
            default:
                break;
        }
    })
    }
}
