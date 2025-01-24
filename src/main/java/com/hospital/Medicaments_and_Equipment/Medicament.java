package com.hospital.Medicaments_and_Equipment;

import com.hospital.App;
import com.hospital.HospitalEntity;

import javafx.collections.ObservableList;

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

    @Override
    public void removeObject(Boolean downCounter){

        ObservableList<Prescription> prescriptions = HospitalEntity.filterAndConvertToObservableList(App.listOfObjects, Prescription.class);
        for(Prescription prescription : prescriptions){

            if(prescription.getMedicaments().containsKey(this)) prescription.getMedicaments().remove(this);
            if(prescription.getMedicaments().isEmpty()) prescription.removeObject(false);
        }
        super.removeObject(downCounter);
    }
}
