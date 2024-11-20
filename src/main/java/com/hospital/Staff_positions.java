package com.hospital;

public enum Staff_positions {
    DOCTOR("Lekarz"),
    NURSE("Pielęgniarka"),
    SECRETARY("Sekretarka"),
    RESCUER("Ratownik");

    private final String value;

    Staff_positions(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }
}
