package com.hospital.Staff_and_patients;

public enum Patient_status {
    ADMITTED("Przyjęty"),
    UNDER_OBSERVATION("Pod obserwacją"),
    CRITICAL_CONDITION("Krytyczny stan"),
    STABLE_CONDITION("Stan stabilny"),
    IMPROVING_CONDITION("Stan poprawiający się"),
    DISCHARGED("Wypisany");

    private final String value;

    Patient_status(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }
}
