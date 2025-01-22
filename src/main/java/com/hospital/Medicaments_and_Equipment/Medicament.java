package com.hospital.Medicaments_and_Equipment;

import com.hospital.App;
import com.hospital.HospitalEntity;

public class Medicament extends HospitalEntity{

    private TypeOfMedicament typeOfMedicament;
    public Medicament(int id,String name, TypeOfMedicament typeOfMedicament)
    {
        super(id, name);
        this.typeOfMedicament =typeOfMedicament;
        App.listOfObjects.add(this);
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
        return name;
    }
}
