package com.hospital.Staff_and_patients;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.hospital.Medicaments_and_Equipment.Prescription;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Patient extends Person {

    private PatientStatus patientStatus;
    private List<String> medicalHistory;
    private List<Prescription> prescriptions;

    public Patient(int id, String name, Gender gender, LocalDate dateOfBirth, String pesel, PatientStatus patientStatus)
    {
        super(id, name, gender, dateOfBirth, pesel);
        this.patientStatus = patientStatus;
        this.medicalHistory = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    public PatientStatus getPatientStatus() {
        return patientStatus;
    }

    public void setPatientStatus(PatientStatus patientStatus) {
        this.patientStatus = patientStatus;
    }

    public List<String> getMedicalHistory() {
        return medicalHistory;
    }

    public void addMedicalHistory(String entry) {
        medicalHistory.add(entry);
    }

    public ObservableList<Prescription> getPrescriptions() {
        ObservableList<Prescription> observablePrescriptionList = FXCollections.observableArrayList(prescriptions);
        return observablePrescriptionList;
    }

    public void addPrescription(Prescription entry) {
        prescriptions.add(entry);
    }

    public void displayInfo()
    {
        System.out.println(String.format(
            "Informacje o pacjencie:\n" +
            "Imię: %s\n" +
            "Płeć: %s\n" +
            "Data urodzenia: %s\n" +
            "PESEL: %s\n" +
            "Status pacjenta: %s",
            name, gender, dateOfBirth,pesel, patientStatus
        ));
        
    }
    @Override
    public String toString() {
        return  "ID: " + id + "\n" +
                "Imię i nazwisko: " + name + "\n" +
                "Płeć: " + gender + "\n" +
                "Data urodzenia: " + dateOfBirth + "\n" +
                "PESEL: " + pesel + "\n";
    }
}
