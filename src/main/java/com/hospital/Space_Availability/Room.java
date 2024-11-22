package com.hospital.Space_Availability;

import java.util.ArrayList;
import java.util.List;

import com.hospital.HospitalEntity;
import com.hospital.Medicaments_and_Equipment.Equipment;

public class Room extends HospitalEntity{

    List<Bed> beds;
    List<Equipment> equipments;

    public Room(int id,String name)
    {
        super(id,name);
        beds = new ArrayList<>();
    }

    public void displayInfo()
    {
        System.out.println
        (
            "numer pokoju: "+name+"\n"+
            "Sale na oddziale: "+"\n"
        );
        for (Bed bed : beds) 
            {
                System.out.println(bed);
            }
        for (Equipment equipment : equipments) 
            {
                System.out.println(equipment);
            }
    }

    @Override
    public String toString() {
        String output="pokój "+name+" z łóżkami: \n";
        for (Bed bed : beds) 
            {
               output+=bed+"\n";
            }
        output+="i osprzętowieniem:\n tutaj na razie jeszcze brakuje kodu";
        return output;
    }

    public void addBed(Bed bed) {
        beds.add(bed);
    }

}
