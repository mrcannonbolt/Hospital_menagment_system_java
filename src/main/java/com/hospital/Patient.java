package com.hospital;

public class Patient extends HospitalEntity{
    int age;
    int gender;

    public Patient(int id,String name, int age,int gender)
    {
        super(id, name);
        this.age=age;
        this.gender = gender;

    }
    public void displayInfo()
    {
        System.out.println("imie: "+name+"\n"+"wiek: "+age);
    }

}
