package com.hospital.Space_Availability;

import java.util.ArrayList;
import java.util.List;

import com.hospital.HospitalEntity;
import com.hospital.Medicaments_and_Equipment.Equipment;

public class Room extends HospitalEntity{

    private List<Bed> beds;
    private List<Equipment> equipments;
    private int capacity;

    public Room(String name)
    {
        super(name);
        beds = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "ID:"+id+" Sala nr: "+name+" Łóżka: "+beds.size();
    }

    public void addBed(Bed bed) {
        beds.add(bed);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public List<Bed> getBeds()
    {
        return beds;
    }

    public void setBeds(List<Bed> beds) {
        this.beds = beds;
    }

}
