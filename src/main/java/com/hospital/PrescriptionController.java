package com.hospital;

import java.io.IOException;

import com.hospital.Medicaments_and_Equipment.Prescription;
import com.hospital.Staff_and_patients.Patient;
import com.hospital.Staff_and_patients.Staff;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class PrescriptionController {
    
    private MainController mainController;
    private Staff staff;

    @FXML
    private ListView<Patient> patientList;
    @FXML
    private ListView<Prescription> prescriptionList;

    @FXML
    public void backMenu() {
        mainController.backToMenuScreen(staff);
    }


    public void setData(Staff staff, ObservableList<Patient> patients) {
        this.staff = staff;
        patientList.setItems(patients);

        patientList.getSelectionModel().selectedItemProperty().addListener((observable, oldPatient, newPatient) -> {
            if (newPatient != null) {
                setPrescriptionList(newPatient);
            }
        });

        prescriptionList.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) { // Podwójne kliknięcie
                Prescription chosePrescription = prescriptionList.getSelectionModel().getSelectedItem();
                if (chosePrescription != null) {
                    openPrescriptionViewWindow(chosePrescription);
                }
            }
        });
    }

    private void openPrescriptionViewWindow(Prescription prescription) {
    try {
        // Załaduj plik FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PrescriptionView.fxml"));
        Parent root = loader.load();

        // Pobierz kontroler i przekaż dane recepty
        PrescriptionViewController controller = loader.getController();
        Stage stage = new Stage();
        controller.setStage(stage);
        controller.setData(patientList.getSelectionModel().getSelectedItem(), prescription);

        // Ustaw scenę i pokaż okno
        stage.setScene(new Scene(root));
        stage.setTitle("Szczegóły recepty");
        stage.setResizable(false);
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }


    public void setPrescriptionList(Patient patient) {
        this.prescriptionList.setItems(patient.getPrescriptions());
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

}
