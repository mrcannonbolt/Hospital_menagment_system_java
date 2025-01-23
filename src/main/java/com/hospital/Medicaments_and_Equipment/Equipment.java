package com.hospital.Medicaments_and_Equipment;

import com.hospital.App;
import com.hospital.HospitalEntity;

public class Equipment extends HospitalEntity{

    private TypeOfEquipment type;

    public Equipment(int id, String name, TypeOfEquipment type) {
        super(id, name);
        this.type = type;
    }

    public void setType(TypeOfEquipment type) {
        this.type = type;
    }

    public TypeOfEquipment getType() {
        return type;
    }
    
}
