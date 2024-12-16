package com.hospital;

import com.hospital.Staff_and_patients.LoginSystem;
import com.hospital.Staff_and_patients.Staff;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
            wrongPasswordLabel.setText("zalogowany");
        }
        else
        {
            wrongPasswordLabel.setText("błędne hasło lub login");
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
