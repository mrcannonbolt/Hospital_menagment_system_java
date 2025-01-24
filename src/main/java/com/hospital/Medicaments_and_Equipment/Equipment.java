package com.hospital.Medicaments_and_Equipment;

import com.hospital.HospitalEntity;

public class Equipment extends HospitalEntity{

    private TypeOfEquipment type;

    public Equipment(String name, TypeOfEquipment type) {
        super(name);
        this.type = type;
    }

    public void setType(TypeOfEquipment type) {
        this.type = type;
    }

    public TypeOfEquipment getType() {
        return type;
    }

}
