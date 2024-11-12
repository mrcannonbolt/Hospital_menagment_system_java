package com.hospital;
import java.util.Date;


// Klasa abstrakcyjna, która definiuje ogólne metody dla jednostek w systemie szpitalnym
public abstract class HospitalEntity{
    protected int id;
    protected String name;
    protected Date date = new Date();

    public HospitalEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public abstract void displayInfo();
}