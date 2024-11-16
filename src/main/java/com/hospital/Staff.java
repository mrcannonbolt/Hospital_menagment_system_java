package com.hospital;

public class Staff extends HospitalEntity{

    public Staff(int id,String name)
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
