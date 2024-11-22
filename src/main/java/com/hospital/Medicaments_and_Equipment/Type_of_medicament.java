package com.hospital.Medicaments_and_Equipment;

public enum Type_of_medicament {
    SYRUP("Syrop"),
    SUSPENSION("Zawiesina"),
    GEL("Żel"),
    INJECTION("Zastrzyk"),
    GRANULES("Granulat"),
    TABLETS("Tabletki"),
    SUPPOSITORIES("Czopki"),
    AEROSOL("Aerozol"),
    OINTMENT("Maść"),
    CREAM("Krem"),
    CAPSULES("Kapsułki");

    private final String value;

    Type_of_medicament(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }
}
