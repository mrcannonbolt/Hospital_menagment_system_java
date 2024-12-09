package com.hospital.Medicaments_and_Equipment;

public enum TypeOfMedicament {
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

    TypeOfMedicament(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }
}
