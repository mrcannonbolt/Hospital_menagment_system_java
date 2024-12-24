package com.hospital;

import com.hospital.Staff_and_patients.LoginSystem;
import com.hospital.Staff_and_patients.Staff;

import com.hospital.Staff_and_patients.StaffPositions;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LoginController {

    @FXML
    private MainController mainController;
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label wrongPasswordLabel;

    @FXML
    public void tryToLoginUser() {
        LoginSystem loginSystem = LoginSystem.getInstance();
        Staff staff=loginSystem.login(loginField.getText(),passwordField.getText());
        if(staff!=null)
        {

            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("MenuScreen.fxml"));
            AnchorPane anchorPane = null;
            try {
                anchorPane = fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            mainController.setScreen(anchorPane);
            MenuController menuController = fxmlLoader.getController();
            menuController.setMainController(mainController);
            menuController.setUser(staff);
        }
        else
        {
            wrongPasswordLabel.setText("Błędne hasło lub login");
        }
    }
    @FXML
    public void tryToExitProgram() {
        Platform.exit();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
