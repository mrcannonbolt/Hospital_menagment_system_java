package com.hospital.Staff_and_patients;

import com.hospital.HospitalEntity;

import java.time.LocalDate;

public class Person extends HospitalEntity {


    protected Gender gender;
    protected String pesel;
    protected LocalDate dateOfBirth;

    public Person(int id,String name,Gender gender,LocalDate dateOfBirth,String pesel)
    {
        super(id, name);
        if (!isValidPesel(pesel)) {
            throw new IllegalArgumentException("Niepoprawny numer PESEL");
        }
        this.gender = gender;
        this.dateOfBirth=dateOfBirth;
        this.pesel = pesel;
    }
    private boolean isValidPesel(String pesel) {
        return isCorrectLength(pesel) && isNumeric(pesel);
    }

    private boolean isCorrectLength(String pesel) {
        return pesel != null && pesel.length() == 11;
    }

    private boolean isNumeric(String pesel) {
        return pesel.matches("\\d{11}");
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}
