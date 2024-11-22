package com.hospital.Medicaments_and_Equipment;

import com.hospital.HospitalEntity;

public class Equipment extends HospitalEntity{

    private Type_of_equipment type;

    public Equipment(int id, String name, Type_of_equipment type) {
        super(id, name);
        this.type = type;
    }

    public void displayInfo() {
        
        System.out.println(
            name+"/n"+
            "typ:"+type
        );
    }

}
