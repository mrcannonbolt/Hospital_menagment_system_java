package com.hospital.Staff_and_patients;

public enum StaffPositions {
    DOCTOR("Lekarz"),
    NURSE("Pielęgniarka"),
    SECRETARY("Sekretarka"),
    RESCUER("Ratownik"),
    IT("IT"),
    IT_ADMIN("Szef IT"),
    HOSPITAL_DIRECTOR("Dyrektor Szpitala");

    private final String value;

    StaffPositions(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }
}
