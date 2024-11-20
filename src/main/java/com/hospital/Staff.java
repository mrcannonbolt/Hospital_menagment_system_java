package com.hospital;

import java.util.Date;

public class Staff extends HospitalEntity{

    private Gender gender;
    private String PESEL;
    private Date date_of_birth;
    private Staff_positions position;
    private String login;
    private String password;

    private boolean isValidPesel(String pesel) {
        return isCorrectLength(pesel) && isNumeric(pesel);
    }

    private boolean isCorrectLength(String pesel) {
        return pesel != null && pesel.length() == 11;
    }

    private boolean isNumeric(String pesel) {
        return pesel.matches("\\d{11}");
    }

    public Staff(int id,String name, Gender gender, String PESEL, Date date_of_birth, Staff_positions position, String login, String password)
    {
        super(id, name);
        if (!isValidPesel(PESEL)) {
            throw new IllegalArgumentException("Niepoprawny numer PESEL");
        }
        this.gender = gender;
        this.PESEL = PESEL;
        this.date_of_birth = date_of_birth;
        this.position = position;
        this.login = login;
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public String getPESEL() {
        return PESEL;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public Staff_positions getPosition() {
        return position;
    }

    public void setPosition(Staff_positions position) {
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

    public void displayInfo()
    {
        System.out.println(String.format(
                "Imię i nazwisko: %s\n" +
                        "Płeć: %s\n" +
                        "PESEL: %s\n" +
                        "Data urodzenia: %s\n" +
                        "Stanowisko: %s\n",
                name,gender,PESEL,DATE_FORMAT.format(date_of_birth),position
        ));
    }

    public String toString()
    {
        return name;
    }
}
