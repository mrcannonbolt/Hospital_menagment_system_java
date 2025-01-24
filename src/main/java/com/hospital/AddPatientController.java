package com.hospital;

import com.hospital.Staff_and_patients.Gender;
import com.hospital.Staff_and_patients.Patient;
import com.hospital.Staff_and_patients.PatientStatus;
import com.hospital.Staff_and_patients.Staff;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class AddPatientController {

    private int lastId=3;

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

    private Staff staff;

    public void setUser(Staff staff) {
        this.staff = staff;
    }

    @FXML
    public void initialize() {
        patientStatus.getItems().addAll(PatientStatus.values());
        patientStatus.setValue(PatientStatus.HOSPITAL_CLIENT);
        patientGender.getItems().addAll(Gender.values());
    }
    @FXML
    public void backMenu() {
        mainController.backToMenuScreen(staff);
    }

    @FXML
    public void addPatient() {
        String name = patientName.getText();
        String pesel = patientPESEL.getText();
        Gender gender = patientGender.getValue();
        LocalDate birthDate = patientDate.getValue();
        PatientStatus status = patientStatus.getValue();
        if (name.isEmpty() || pesel.isEmpty() || gender == null || birthDate == null || status == null) {
            showAlert("Błąd", "Wszystkie pola muszą być wypełnione.", Alert.AlertType.ERROR);
            return;
        }
        try {
            Patient newPatient = new Patient(name, gender, birthDate, pesel, status);
            App.listOfObjects.add(newPatient);
            showAlert("Sukces","Udało się dodać nowego pacjenta do bazy\n" + newPatient, Alert.AlertType.INFORMATION);
        } catch (IllegalArgumentException e) {
            showAlert("Błąd", e.getMessage(), Alert.AlertType.ERROR);
        }

    }
    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
