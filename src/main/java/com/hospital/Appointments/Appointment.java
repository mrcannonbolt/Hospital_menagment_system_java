package com.hospital.Appointments;

import com.hospital.Staff_and_patients.Patient;
import com.hospital.Staff_and_patients.Staff;

import java.time.LocalDateTime;

public class Appointment {
    private Staff doctor;
    private Patient patient;
    private LocalDateTime dateTime;
    private String description;

    public Appointment(Staff doctor, Patient patient, LocalDateTime dateTime, String description) {
        this.doctor = doctor;
        this.patient = patient;
        this.dateTime = dateTime;
        this.description = description;
    }

    public Staff getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Wizyta:\n" +
                "Lekarz: " + doctor.getName() + "\n" +
                "Pacjent: " + patient.getName() + "\n" +
                "Data i godzina: " + dateTime + "\n" +
                "Opis: " + description + "\n";
    }
}