package com.hospital.Space_Availability;

import java.util.ArrayList;
import java.util.List;

import com.hospital.HospitalEntity;
import com.hospital.Medicaments_and_Equipment.Equipment;

public class Room extends HospitalEntity{

    private List<Bed> beds;
    private List<Equipment> equipments;
    private int capacity;

    public Room(int id,String name)
    {
        super(id,name);
        beds = new ArrayList<>();
    }

    @Override
    public String toString() {
        String output="pokój "+name+" z łóżkami: \n";
        for (Bed bed : beds) 
            {
               output+=bed+"\n";
            }
        for (Equipment equipment : equipments) 
            {
               output+=equipment+"\n";
            }
        return output;
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
}
