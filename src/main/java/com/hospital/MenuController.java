package com.hospital;

import com.hospital.Staff_and_patients.Staff;
import com.hospital.Staff_and_patients.StaffPositions;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MenuController {

    @FXML
    private MainController mainController;

    @FXML
    private Button registerButton;

    @FXML
    private Button visitButton;

    @FXML
    private Button receiptButton;

    @FXML
    private Button staffButton;

    @FXML
    private Button addPatientButton;

    @FXML
    private Button medicalHistoryButton;

    @FXML
    public void configureMenu(Staff staff) {
        StaffPositions staffPosition = staff.getPosition();
        medicalHistoryButton.setVisible(false);
        addPatientButton.setVisible(false);
        registerButton.setVisible(false);
        visitButton.setVisible(false);
        receiptButton.setVisible(false);
        staffButton.setVisible(false);
        switch (staffPosition) {
            case NURSE:
                addPatientButton.setVisible(true);
                registerButton.setVisible(true);
                medicalHistoryButton.setVisible(true);
                break;
            case DOCTOR:
                addPatientButton.setVisible(true);
                registerButton.setVisible(true);
                visitButton.setVisible(true);
                receiptButton.setVisible(true);
                medicalHistoryButton.setVisible(true);
                break;
            case SECRETARY:
                registerButton.setVisible(true);
                visitButton.setVisible(true);
                medicalHistoryButton.setVisible(true);
                receiptButton.setVisible(true);
                break;
            case RESCUER:
                registerButton.setVisible(true);
                receiptButton.setVisible(true);
                medicalHistoryButton.setVisible(true);
                break;
            case IT:
                addPatientButton.setVisible(true);
                registerButton.setVisible(true);
                visitButton.setVisible(true);
                receiptButton.setVisible(true);
                staffButton.setVisible(true);
                medicalHistoryButton.setVisible(true);
                break;
            case IT_ADMIN:
                addPatientButton.setVisible(true);
                registerButton.setVisible(true);
                visitButton.setVisible(true);
                receiptButton.setVisible(true);
                staffButton.setVisible(true);
                medicalHistoryButton.setVisible(true);
                break;
            case HOSPITAL_DIRECTOR:
                addPatientButton.setVisible(true);
                registerButton.setVisible(true);
                visitButton.setVisible(true);
                receiptButton.setVisible(true);
                staffButton.setVisible(true);
                medicalHistoryButton.setVisible(true);
                break;
            default:
                System.out.println("ERROR!");
        }
    }

    @FXML
    public void setUser(Staff staff) {
        configureMenu(staff);
    }

    @FXML
    public void runAddingPatients() {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("addPatientWindow.fxml"));
        AnchorPane anchorPane = null;
        try {
            anchorPane = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        mainController.setScreen(anchorPane);
        AddPatientController addPatientController = fxmlLoader.getController();
        addPatientController.setMainController(mainController);
    }

    @FXML
    public void runReceipts() {

    }

    @FXML
    public void runStaffManagement() {

    }

    @FXML
    public void runMedicalHistory() {

    }

    @FXML
    public void runVisits() {

    }

    @FXML
    public void runRegisteringPatient() {

    }

    @FXML
    public void tryToExitProgram() {
        Platform.exit();
    }
    @FXML
    public void tryToLoginAgain() {
    mainController.loadLoginScreen();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}