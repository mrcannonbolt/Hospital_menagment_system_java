package com.hospital;

import com.hospital.Appointments.AppointmentManager;
import com.hospital.Medicaments_and_Equipment.Medicament;
import com.hospital.Staff_and_patients.Patient;
import com.hospital.Staff_and_patients.Staff;
import com.hospital.Staff_and_patients.StaffPositions;
import javafx.application.Platform;
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
    private ObservableList<Medicament> medicaments;

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

    private static Staff staff;

    @FXML
    public void configureMenu(Staff staff) {
        StaffPositions staffPosition = staff.getPosition();
        medicalHistoryButton.setDisable(true);
        addPatientButton.setDisable(true);
        registerButton.setDisable(true);
        visitButton.setDisable(true);
        receiptButton.setDisable(true);
        staffButton.setDisable(true);
        switch (staffPosition) {
            case NURSE:
                addPatientButton.setDisable(false);
                registerButton.setDisable(false);
                medicalHistoryButton.setDisable(false);
                break;
            case DOCTOR:
                addPatientButton.setDisable(false);
                registerButton.setDisable(false);
                visitButton.setDisable(false);
                receiptButton.setDisable(false);
                medicalHistoryButton.setDisable(false);
                break;
            case SECRETARY:
                registerButton.setDisable(false);
                visitButton.setDisable(false);
                medicalHistoryButton.setDisable(false);
                receiptButton.setDisable(false);
                break;
            case RESCUER:
                registerButton.setDisable(false);
                receiptButton.setDisable(false);
                medicalHistoryButton.setDisable(false);
                break;
            case IT:
                addPatientButton.setDisable(false);
                registerButton.setDisable(false);
                visitButton.setDisable(false);
                receiptButton.setDisable(false);
                staffButton.setDisable(false);
                medicalHistoryButton.setDisable(false);
                break;
            case IT_ADMIN:
                addPatientButton.setDisable(false);
                registerButton.setDisable(false);
                visitButton.setDisable(false);
                receiptButton.setDisable(false);
                staffButton.setDisable(false);
                medicalHistoryButton.setDisable(false);
                break;
            case HOSPITAL_DIRECTOR:
                addPatientButton.setDisable(false);
                registerButton.setDisable(false);
                visitButton.setDisable(false);
                receiptButton.setDisable(false);
                staffButton.setDisable(false);
                medicalHistoryButton.setDisable(false);
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

    // Przygotowanie danych
    private void prepareDate()
    {
        doctors = HospitalEntity.filterAndConvertToObservableList(App.listOfObjects, Staff.class);

        patients = HospitalEntity.filterAndConvertToObservableList(App.listOfObjects, Patient.class);

        medicaments = HospitalEntity.filterAndConvertToObservableList(App.listOfObjects, Medicament.class);

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
        addPatientController.setUser(staff);
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
    public void runAddingPrescription() {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("addPrescriptionWindow.fxml"));
        AnchorPane anchorPane = null;
        try {
            anchorPane = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        mainController.setScreen(anchorPane);
        AddPrescriptionController addPrescriptionController = fxmlLoader.getController();
        prepareDate();
        addPrescriptionController.setData(staff,patients,medicaments);
        addPrescriptionController.setMainController(mainController);
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
        staffManagementController.setUser(staff);
    }

    @FXML
    public void runMedicalHistory() {

    }

    @FXML
    public void runPrescriptions() {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("Prescriptions.fxml"));
        AnchorPane anchorPane = null;
        try {
            anchorPane = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        mainController.setScreen(anchorPane);
        PrescriptionController PrescriptionController = fxmlLoader.getController();
        prepareDate();
        PrescriptionController.setData(staff,patients);
        PrescriptionController.setMainController(mainController);
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
        prepareDate();
        bookAppointmentController.setData(staff, AppointmentManager.getInstance(),doctors,patients);
    }

    @FXML
    public void runRegisteringPatient() {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("registerPatientInHospital.fxml"));
        AnchorPane anchorPane = null;
        try {
            anchorPane = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        mainController.setScreen(anchorPane);
        RegisterPatientInHospitalController registerPatientInHospitalController = fxmlLoader.getController();
        registerPatientInHospitalController.setMainController(mainController);
        registerPatientInHospitalController.setData(staff);
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