package com.hospital.Staff_and_patients;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hospital.Medicaments_and_Equipment.Prescription;

public class Patient extends Person {

    private PatientStatus patientStatus;
    private List<String> medicalHistory;
    private List<Prescription> prescriptions;

    public Patient(int id, String name, Gender gender, Date dateOfBirth, String pesel, PatientStatus patientStatus)
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

    public void getPrescriptions() {
        for(Prescription prescription:prescriptions)
            prescription.displayInfo();
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
            "Status zdrowia pacjenta: %s",
            name, gender, DATE_FORMAT.format(dateOfBirth),pesel, medicalHistory
        ));
        
    }

    @Override
    public String toString() {
        return name;
    }

}
