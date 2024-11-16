package com.hospital;

public class Medicament extends HospitalEntity{

    public Medicament(int id,String name)
    {
        super(id, name);
    }

    public void displayInfo()
    {
        System.out.println(name);
    }

    public String toString()
    {
        return name;
    }
}
