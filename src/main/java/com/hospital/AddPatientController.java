package com.hospital;

import com.hospital.Staff_and_patients.Gender;
import com.hospital.Staff_and_patients.Patient;
import com.hospital.Staff_and_patients.PatientStatus;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class AddPatientController {

    @FXML
    private MainController mainController;

    @FXML
    private TextField patientName;

    @FXML
    private TextField patientPESEL;

    @FXML
    private ComboBox<Gender> patientGender;

    @FXML
    private ComboBox<PatientStatus> patientStatus;

    @FXML
    private DatePicker patientDate;

    @FXML
    public void initialize() {
        patientStatus.getItems().addAll(PatientStatus.values());
        patientStatus.setValue(PatientStatus.HOSPITAL_CLIENT);
        patientGender.getItems().addAll(Gender.values());
    }
    @FXML
    public void backMenu() {
        mainController.loadMenuScreen();
    }

    @FXML
    public void addPatient() {
        String name = patientName.getText();
        String pesel = patientPESEL.getText();
        Gender gender = patientGender.getValue();
        LocalDate localDate = patientDate.getValue();
        PatientStatus status = patientStatus.getValue();
        if (name.isEmpty() || pesel.isEmpty() || gender == null || localDate == null || status == null) {
            System.out.println("Wszystkie pola muszą być wypełnione.");
        }
        Patient newPatient = new Patient(2, name, gender, localDate, pesel, status);
        System.out.println("Pacjent dodany:\n" + newPatient);
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
