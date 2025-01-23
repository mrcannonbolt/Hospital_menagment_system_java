package com.hospital;

import com.hospital.Staff_and_patients.Gender;
import com.hospital.Staff_and_patients.Patient;
import com.hospital.Staff_and_patients.PatientStatus;
import com.hospital.Staff_and_patients.Staff;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PatientHistoryViewController {

    private MainController mainController;
    @FXML
    private TextField patientName;
    @FXML
    private TextField patientPesel;
    @FXML
    private TextField newHistoryEntry;
    @FXML
    private ComboBox<Gender> patientGender;
    @FXML
    private ComboBox<PatientStatus> patientStatus;
    @FXML
    private DatePicker patientDate;
    @FXML
    private ListView<String> patientHistory;
    @FXML
    private ListView<Patient> patientList;

    private Staff staff;
    @FXML
    private Button editButton;
    @FXML
    private Button saveButton;

    private boolean isEditMode = false;

    @FXML
    public void initialize() {
        patientGender.getItems().addAll(Gender.values());
        patientStatus.getItems().addAll(PatientStatus.values());
    }

    public void setData(Staff staff, ObservableList<Patient> patients) {
        this.staff=staff;
        patientList.setItems(patients);
        // Dodanie listenera do `ListView`
        patientList.getSelectionModel().selectedItemProperty().addListener((obs, oldPatient, newPatient) -> {
            if (newPatient != null) {
                loadPatientDetails(newPatient);
                toggleEditMode(false);
            }
        });
    }


    public void backMenu() {
    mainController.backToMenuScreen(staff);
    }

    private void loadPatientDetails(Patient patient) {
        patientName.setText(patient.getName());
        patientGender.setValue(patient.getGender());
        patientDate.setValue(patient.getDateOfBirth());
        patientPesel.setText(patient.getPesel());
        patientStatus.setValue(patient.getPatientStatus());
        patientHistory.setItems(FXCollections.observableArrayList(patient.getMedicalHistory()));
        newHistoryEntry.clear();
    }

    public void saveDetails() {
        Patient selectedPatient = patientList.getSelectionModel().getSelectedItem();
        if (selectedPatient != null) {
            selectedPatient.setName(patientName.getText());
            selectedPatient.setGender(patientGender.getValue());
            selectedPatient.setDateOfBirth(patientDate.getValue());
            selectedPatient.setPesel(patientPesel.getText());
            selectedPatient.setPatientStatus(patientStatus.getValue());
            String newHistory = newHistoryEntry.getText().trim();
            if (!newHistory.isEmpty()) {
                selectedPatient.addMedicalHistory(newHistory);
                patientHistory.getItems().add(newHistory);
                newHistoryEntry.clear();
            }
            // Wyłącz tryb edycji
            toggleEditMode(false);
            showAlert("Sukses","Dane pacjenta zostały zapisane.",Alert.AlertType.INFORMATION);
            showAlert("Błąd", "Wszystkie pola muszą być wypełnione.", Alert.AlertType.ERROR);
        }
    }
    public void editData() {
        toggleEditMode(true);
    }

    public void toggleEditMode(boolean enable) {
        isEditMode = enable;

        patientName.setEditable(enable);
        patientGender.setDisable(!enable);
        patientDate.setDisable(!enable);
        patientPesel.setEditable(enable);
        patientStatus.setDisable(!enable);
        newHistoryEntry.setEditable(enable);
        saveButton.setDisable(!enable);
        editButton.setDisable(enable);
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
