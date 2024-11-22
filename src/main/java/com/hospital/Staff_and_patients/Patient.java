package com.hospital.Staff_and_patients;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hospital.HospitalEntity;
import com.hospital.Medicaments_and_Equipment.Prescription;

public class Patient extends HospitalEntity{

    private Gender gender;
    private String PESEL;
    private Date date_of_birth;
    private Patient_status patient_status;
    private List<String> medical_history;
    private List<Prescription> prescriptions;

    private boolean isValidPesel(String pesel) {
        return isCorrectLength(pesel) && isNumeric(pesel);
    }

    private boolean isCorrectLength(String pesel) {
        return pesel != null && pesel.length() == 11;
    }

    private boolean isNumeric(String pesel) {
        return pesel.matches("\\d{11}");
    }
    public Patient(int id,String name,Gender gender,Date date_of_birth,String pesel,Patient_status patient_status)
    {
        super(id, name);
        if (!isValidPesel(pesel)) {
            throw new IllegalArgumentException("Niepoprawny numer PESEL");
        }
        this.gender = gender;
        this.date_of_birth=date_of_birth;
        this.PESEL = pesel;
        this.patient_status = patient_status;
        this.medical_history = new ArrayList<>();
        this.prescriptions = new ArrayList<>();

    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public Date getDateOfBirth() {
        return date_of_birth;
    }

    public void setDateOfBirth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Patient_status getPatientStatus() {
        return patient_status;
    }

    public void setPatientStatus(Patient_status patient_status) {
        this.patient_status = patient_status;
    }

    public List<String> getMedicalHistory() {
        return medical_history;
    }

    public void addMedicalHistory(String entry) {
        medical_history.add(entry);
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
            name, gender, DATE_FORMAT.format(date_of_birth), PESEL, patient_status
        ));
        
    }

    @Override
    public String toString() {
        return name;
    }

}
