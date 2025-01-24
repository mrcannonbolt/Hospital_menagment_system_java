package com.hospital.Staff_and_patients;

import java.time.LocalDate;

public class Staff extends Person {

    private StaffPositions position;
    private String login;
    private String password;

    public Staff(String name, Gender gender, String pesel, LocalDate dateOfBirth, StaffPositions position, String login, String password)
    {
        super(name, gender, dateOfBirth, pesel);
        this.position = position;
        this.login = login;
        this.password = password;
    }


    public StaffPositions getPosition() {
        return position;
    }

    public void setPosition(StaffPositions position) {
        this.position = position;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public boolean authorization(String inputPassword) {
        return password.equals(inputPassword);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return  "ID: " + id +
                "   Imię i nazwisko: " + name + "\n" +
                "Płeć: " + gender +
                "   Data urodzenia: " + dateOfBirth + "\n" +
                "PESEL: " + pesel +
                "   Stanowisko: " + position + "\n";
    }
}
