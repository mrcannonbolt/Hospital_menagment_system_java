package com.hospital;

import java.util.List;

import com.hospital.Space_Availability.Bed;
import com.hospital.Space_Availability.Department;
import com.hospital.Space_Availability.Room;
import com.hospital.Staff_and_patients.Gender;
import com.hospital.Staff_and_patients.Patient;
import com.hospital.Staff_and_patients.PatientStatus;
import com.hospital.Staff_and_patients.Staff;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class RegisterPatientInHospitalController {

    private MainController mainController;

    @FXML
    private ListView<Patient> registeringPatient;
    @FXML
    private ComboBox<Department> departmentPatient;
    @FXML
    private ComboBox<Room> roomPatient;
    @FXML
    private ComboBox<Bed> bedPatient;
    @FXML
    private ComboBox<PatientStatus> patientStatus;

    private Staff staff;

    @FXML
    public void setData(Staff staff,ObservableList<Patient> patients,ObservableList<Department> departments) {
        this.staff=staff;
        registeringPatient.setItems(patients);
        departmentPatient.setItems(departments);
        patientStatus.getItems().addAll(PatientStatus.values());
        roomPatient.setDisable(true);
        bedPatient.setDisable(true);

        departmentPatient.valueProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                ObservableList<Room> rooms = FXCollections.observableArrayList(newVal.getRooms());
                roomPatient.setItems(rooms);
                roomPatient.setDisable(false);
                bedPatient.setDisable(true); // Reset łóżek
                bedPatient.getItems().clear();
            }
        });
        // Listener dla wyboru sali
        roomPatient.valueProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                ObservableList<Bed> roomBeds = FXCollections.observableArrayList(newVal.getBeds());
                bedPatient.setItems(FXCollections.observableArrayList(roomBeds));
                bedPatient.setDisable(false);
            }
        });

        patientStatus.valueProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                if(newVal==PatientStatus.DISCHARGED || newVal==PatientStatus.HOSPITAL_CLIENT){
                    departmentPatient.setDisable(true);
                    roomPatient.setDisable(true);
                    bedPatient.setDisable(true);
                    departmentPatient.getSelectionModel().clearSelection();
                    roomPatient.getSelectionModel().clearSelection();
                    bedPatient.getSelectionModel().clearSelection();
                }
                else{
                    departmentPatient.setDisable(false);
                }
            }
        });
    }
    @FXML
    public void backMenu() {
        mainController.backToMenuScreen(staff);
    }
    @FXML
    public void registerPatient() {
        if(registeringPatient.getSelectionModel().getSelectedItem()!=null && patientStatus.getSelectionModel().getSelectedItem()!=null){
            Patient patient = registeringPatient.getSelectionModel().getSelectedItem();
            PatientStatus Status = patientStatus.getSelectionModel().getSelectedItem();

            if(Status == PatientStatus.DISCHARGED || Status == PatientStatus.HOSPITAL_CLIENT){
                if(patient.getAssignedBed()!=null){
                    patient.getAssignedBed().releaseBed();
                    patient.setAssignedBed(null);
                }
                showAlert("Powodzenie","Udało się zmienić stan pacjenta",Alert.AlertType.INFORMATION);
                return;
            }

            if(bedPatient.getSelectionModel().getSelectedItem()!=null){
                Bed bed = bedPatient.getSelectionModel().getSelectedItem();
                if(bed.isFree()){
                    
                    if (patient.getAssignedBed()!=null) {
                        showAlert("Informacja","Pacjent miał już przydzielone łóżko, zostanie ono zmienione",Alert.AlertType.INFORMATION);
                        patient.getAssignedBed().releaseBed();
                        patient.setAssignedBed(null);
                    }

                    bed.assignPatient(patient);
                    patient.setAssignedBed(bed);
                    showAlert("Powodzenie","Udało się zarejestrować pacjenta",Alert.AlertType.INFORMATION);
                    backMenu();
                    return;
                }
                else showAlert("Błąd","To łóżko jest zajęte.",Alert.AlertType.WARNING);
            }
            else showAlert("Błąd","Proszę uzupełnić/wybrać wszystkie potrzebne pola.",Alert.AlertType.WARNING);
        }
        else showAlert("Błąd","Proszę uzupełnić/wybrać wszystkie potrzebne pola.",Alert.AlertType.WARNING);
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
