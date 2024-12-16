package com.hospital.Medicaments_and_Equipment;

import com.hospital.HospitalEntity;

public class Medicament extends HospitalEntity{

    private TypeOfMedicament typeOfMedicament;
    public Medicament(int id,String name, TypeOfMedicament typeOfMedicament)
    {
        super(id, name);
        this.typeOfMedicament =typeOfMedicament;
    }

    public void setTypeOfMedicament(TypeOfMedicament typeOfMedicament) {
        this.typeOfMedicament = typeOfMedicament;
    }

    public TypeOfMedicament getTypeOfMedicament() {
        return typeOfMedicament;
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
