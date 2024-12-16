package com.hospital.Medicaments_and_Equipment;

public enum TypeOfEquipment {

    MONITORING("Monitorowanie"),
    LIFE_SUPPORT("Podtrzymywanie życia"),
    DIAGNOSTIC("Diagnostyka"),
    SURGICAL("Chirurgia"),
    GENERAL_USE("Użytek ogólny");

    private final String value;

    TypeOfEquipment(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }
}
