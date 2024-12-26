package com.hospital;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class MainController {

    @FXML
    private StackPane mainStackPane;

    @FXML
    public void initialize() {
        loadLoginScreen();
    }

    public void loadLoginScreen() {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("LoginWindow.fxml"));
        AnchorPane anchorPane = null;
        try {
            anchorPane = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setScreen(anchorPane);
        LoginController loginController = fxmlLoader.getController();
        loginController.setMainController(this);
    }
    public void loadMenuScreen() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MenuScreen.fxml"));
        AnchorPane anchorPane;
        try {
            anchorPane = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException("Nie udało się załadować Menu", e);
        }
        setScreen(anchorPane);
        MenuController menuController = fxmlLoader.getController();
        menuController.setMainController(this);
    }
    public void setScreen(AnchorPane anchorPane) {
        mainStackPane.getChildren().clear();
        mainStackPane.getChildren().add(anchorPane);
    }
}
