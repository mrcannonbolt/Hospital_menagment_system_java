package com.hospital.Staff_and_patients;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.hospital.App;
import com.hospital.HospitalEntity;
import com.hospital.Appointments.Appointment;
import com.hospital.Medicaments_and_Equipment.Prescription;
import com.hospital.Space_Availability.Bed;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Patient extends Person {

    private PatientStatus patientStatus;
    private List<String> medicalHistory;
    private List<Prescription> prescriptions;
    private Bed assignedBed;

    public Patient(String name, Gender gender, LocalDate dateOfBirth, String pesel, PatientStatus patientStatus)
    {
        super(name, gender, dateOfBirth, pesel);
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

    @Override
    public String toString() {
        return  "ID: " + id +
                "   Imię i nazwisko: " + name + "\n" +
                "Płeć: " + gender + 
                "   Data urodzenia: " + dateOfBirth + "\n" +
                "PESEL: " + pesel;
    }

    public void setAssignedBed(Bed assignedBed) {
        this.assignedBed = assignedBed;
    }

    public Bed getAssignedBed() {
        return assignedBed;
    }
    
    public void removeObject(Boolean downCounter) {
    ObservableList<Appointment>  appointments= HospitalEntity.filterAndConvertToObservableList(App.listOfObjects, Appointment.class);
    for (Appointment appointment : appointments) appointment.removeObject(downCounter);
    if(downCounter==false)getAssignedBed().releaseBed();
    super.removeObject(downCounter);
    }
}
