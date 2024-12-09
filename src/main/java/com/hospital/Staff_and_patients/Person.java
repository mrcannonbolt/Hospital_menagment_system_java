package com.hospital.Staff_and_patients;

import com.hospital.HospitalEntity;

import java.util.Date;

public class Person extends HospitalEntity {


    protected Gender gender;
    protected String pesel;
    protected Date dateOfBirth;

    public Person(int id,String name,Gender gender,Date dateOfBirth,String pesel)
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
        this.pesel = this.pesel;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public void displayInfo()
        {
            System.out.println(String.format(
                    "Informacje o pacjencie:\n" +
                            "Imię: %s\n" +
                            "Płeć: %s\n" +
                            "Data urodzenia: %s\n" +
                            "PESEL: %s",
                    name, gender, DATE_FORMAT.format(dateOfBirth), pesel
            ));

        }

}
