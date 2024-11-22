package com.hospital.Staff_and_patients;

public enum Gender {
    WOMAN("Kobieta"),
    MAN("Mężczyzna");

    private final String value;

    Gender(String value)
    {
        this.value=value;
    }
    
    public String toString() 
    {
        return value;
    }
}
