package com.hospital;


import java.util.Map;

import com.hospital.Medicaments_and_Equipment.Medicament;
import com.hospital.Medicaments_and_Equipment.Prescription;
import com.hospital.Medicaments_and_Equipment.PrescriptionList;
import com.hospital.Staff_and_patients.Patient;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class PrescriptionViewController {
    
    private Stage stage;
    private Prescription prescription;

    @FXML
    private Label patientInfo;
    @FXML
    private ListView<PrescriptionList> medicamentsList;
    @FXML
    private Label issuingDoctor;
    @FXML
    private Label expirationDate;
    @FXML
    private Label pickupCode;

    public void setData(Patient patient, Prescription prescription) {
        this.prescription = prescription;
        patientInfo.setText("Dane pacjenta:\n"+patient);
        issuingDoctor.setText("Doktor wystawiający:\n"+prescription.getIssuingDoctor().toString());
        expirationDate.setText("Data ważności:\n"+prescription.getExpirationDate());
        pickupCode.setText("Kod odbioru:\n"+prescription.getPickupCode());
        setMedicamentsList();
    }

    public void setMedicamentsList(){
        Integer i = 1;
        ObservableList<PrescriptionList> observableMedicamentsList = FXCollections.observableArrayList();
        for (Map.Entry<Medicament, Integer> entry : prescription.getMedicaments().entrySet()) {
            Medicament medicament = entry.getKey();
            Integer count = entry.getValue();
            observableMedicamentsList.add(new PrescriptionList(i, medicament, medicament.getTypeOfMedicament(), count));
            i++;
            }
            medicamentsList.setItems(observableMedicamentsList);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void closeWindow() {
        if (stage != null) {
            stage.close();
        }
    }

}
