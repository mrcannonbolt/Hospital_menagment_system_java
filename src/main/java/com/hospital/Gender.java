package com.hospital;

public enum Gender {
    WOMAN("Kobieta"),
    MAN("Mężczyna");

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
