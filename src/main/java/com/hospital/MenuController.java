package com.hospital;

import com.hospital.Appointments.AppointmentManager;
import com.hospital.Staff_and_patients.Patient;
import com.hospital.Staff_and_patients.Staff;
import com.hospital.Staff_and_patients.StaffPositions;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    @FXML
    private MainController mainController;

    private ObservableList<Staff> doctors;
    private ObservableList<Patient> patients;

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

    private Staff staff;

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
        this.staff=staff;
        configureMenu(staff);
    }

    private void prepareDoctorAndPatientsListsForAppointments() {
        doctors = FXCollections.observableArrayList(AppointmentManager.getInstance().getStaffMembers());

        patients = FXCollections.observableArrayList(AppointmentManager.getInstance().getPatients());
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
    public void runAppointmentsOnToday() {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("DoctorAppointmentsWindow.fxml"));
        AnchorPane anchorPane = null;
        try {
            anchorPane = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        mainController.setScreen(anchorPane);
        DoctorAppointmentsController doctorAppointmentsController = fxmlLoader.getController();
        doctorAppointmentsController.setMainController(mainController);
        doctorAppointmentsController.setData(AppointmentManager.getInstance(), staff);
    }

    @FXML
    public void runReceipts() {

    }

    @FXML
    public void runStaffManagement() {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("StaffManagementWindow.fxml"));
        AnchorPane anchorPane = null;
        try {
            anchorPane = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        mainController.setScreen(anchorPane);
        StaffManagementController staffManagementController = fxmlLoader.getController();
        staffManagementController.setMainController(mainController);
    }

    @FXML
    public void runMedicalHistory() {

    }

    @FXML
    public void runVisits() {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("BookAppointmentWindow.fxml"));
        AnchorPane anchorPane = null;
        try {
            anchorPane = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        mainController.setScreen(anchorPane);
        BookAppointmentController bookAppointmentController = fxmlLoader.getController();
        bookAppointmentController.setMainController(mainController);
        prepareDoctorAndPatientsListsForAppointments();
        bookAppointmentController.setUser(staff);
        bookAppointmentController.setData(AppointmentManager.getInstance(),doctors,patients);
    }

    @FXML
    public void runRegisteringPatient() {

    }

    @FXML
    public void runOptions() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("optionsWindow.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Opcje programu");
            stage.setScene(new Scene(root));
            OptionsController optionsController = loader.getController();
            optionsController.setUser(staff);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
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