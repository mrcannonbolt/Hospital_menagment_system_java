package com.hospital.Medicaments_and_Equipment;

import com.hospital.App;
import com.hospital.HospitalEntity;

import javafx.collections.FXCollections;

public class Medicament extends HospitalEntity{

    private TypeOfMedicament typeOfMedicament;
    public Medicament(String name, TypeOfMedicament typeOfMedicament)
    {
        super(name);
        this.typeOfMedicament =typeOfMedicament;
    }

    public void setTypeOfMedicament(TypeOfMedicament typeOfMedicament) {
        this.typeOfMedicament = typeOfMedicament;
    }

    public TypeOfMedicament getTypeOfMedicament() {
        return typeOfMedicament;
    }

    @Override
    public String toString()
    {
        return "ID:"+id+" Lek: "+name;
    }
}
