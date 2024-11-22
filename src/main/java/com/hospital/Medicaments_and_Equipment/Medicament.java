package com.hospital.Medicaments_and_Equipment;

import com.hospital.HospitalEntity;

public class Medicament extends HospitalEntity{

    private Type_of_medicament typeOfMedicament;
    public Medicament(int id,String name, Type_of_medicament typeOfMedicament)
    {
        super(id, name);
        this.typeOfMedicament =typeOfMedicament;
    }

    public void setTypeOfMedicament(Type_of_medicament typeOfMedicament) {
        this.typeOfMedicament = typeOfMedicament;
    }

    public Type_of_medicament getTypeOfMedicament() {
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
