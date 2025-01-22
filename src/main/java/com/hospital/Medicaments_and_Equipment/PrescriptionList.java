package com.hospital.Medicaments_and_Equipment;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;


public class PrescriptionList {
    private final IntegerProperty id;
    private final ObjectProperty<Medicament> medicament;
    private final ObjectProperty<TypeOfMedicament> type;
    private final IntegerProperty count;

    public PrescriptionList(int id, Medicament medicament, TypeOfMedicament type, int count) {
        this.id = new SimpleIntegerProperty(id);
        this.medicament = new SimpleObjectProperty<>(medicament);
        this.type = new SimpleObjectProperty<>(type);
        this.count = new SimpleIntegerProperty(count);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public ObjectProperty<Medicament> medicamentProperty() {
        return medicament;
    }

    public ObjectProperty<TypeOfMedicament> typeProperty() {
        return type;
    }

    public IntegerProperty countProperty() {
        return count;
    }

    public String toString(){
        return(id.getValue()+"     "+medicament.getValue()+"      "+type.getValue()+"      ilość:"+count.getValue());
    }
}

