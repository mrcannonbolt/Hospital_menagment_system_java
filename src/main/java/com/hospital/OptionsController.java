package com.hospital;

import com.hospital.Staff_and_patients.Staff;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class OptionsController {

    @FXML
    private Label titleLabel;

    private Staff staff;

    @FXML
    public void exitWindow() {
        Stage stage = (Stage) titleLabel.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void setUser(Staff staff) {
        this.staff=staff;
    }
    @FXML
    public void changePassword() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("changePasswordWindow.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Zmiana hasła");
            stage.setScene(new Scene(root));
            ChangePasswordController changePasswordController = loader.getController();
            changePasswordController.setUser(staff);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
