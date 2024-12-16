package com.hospital.Staff_and_patients;

import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Terminal {

    public void show() {
        Stage terminalStage = new Stage();
        TextArea terminal = new TextArea();
        terminal.setPromptText("Type your command here...");
        // Obsługa ENTER
        terminal.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case ENTER:
                    String command = terminal.getText().trim(); // Pobierz komendę
                    terminal.appendText("\n> " + processCommand(command)); // Wyświetl wynik
                    terminal.setScrollTop(Double.MAX_VALUE); // Przewijanie na dół
                    event.consume(); // Zablokuj nową linię w TextArea
                    break;
                default:
                    break;
            }
        });

        VBox layout = new VBox(terminal);
        Scene scene = new Scene(layout, 800, 400);

        terminalStage.setTitle("Hospital Management Terminal");
        terminalStage.setScene(scene);
        terminalStage.show();
    }

    // Prosty parser komend
    private String processCommand(String command) {
        if (command.startsWith("add patient")) {
            String[] parts = command.split(" ");
            if (parts.length >= 4) {
                String name = parts[2];
                int age = Integer.parseInt(parts[3]);
                return "Patient " + name + " (age " + age + ") added successfully!";
            } else {
                return "Invalid command. Usage: add patient <name> <age>";
            }
        } else if (command.equals("list patient")) {
            return "Listing all patients...";
        } else {
            return "Unknown command: " + command;
        }
    }
}
