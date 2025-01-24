package com.hospital.Medicaments_and_Equipment;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;

import com.hospital.App;
import com.hospital.HospitalEntity;
import com.hospital.PrescriptionController;
import com.hospital.Staff_and_patients.Patient;
import com.hospital.Staff_and_patients.Staff;

import javafx.collections.ObservableList;

public class Prescription extends HospitalEntity {

    private Map<Medicament, Integer> medicaments;
    private static List<Integer> pickupCodesList= new ArrayList<>();
    private Integer pickupCode;
    private Staff issuingDoctor;
    private Date expirationDate;

    public Prescription(String name, Staff issuingDoctor, Map<Medicament, Integer> medicaments) {
        super(name);
        if(medicaments == null){
            this.medicaments = new HashMap<>();
        }
        else{
            this.medicaments = medicaments;
        }
        this.issuingDoctor = issuingDoctor;
        this.expirationDate = calculateExpirationDate(date, 60);
        this.pickupCode = assignPickupCode();
    }

    private Date calculateExpirationDate(Date date, int daysToAdd) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, daysToAdd);
        return calendar.getTime();
    }

    private Integer assignPickupCode() {
        Integer assignNumber;
        do
        {
            assignNumber=ThreadLocalRandom.current().nextInt(100000, 999999);
        }
        while(pickupCodesList.contains(assignNumber));
        return assignNumber;
    }

    public void addMedicament(Medicament medicament, int quantity) {
            medicaments.put(medicament, quantity);
    }

    public void removeMedicament(Medicament medicament) {
        medicaments.remove(medicament);
    }

    public void updateQuantity(Medicament medicament, int newQuantity) {
        medicaments.put(medicament, newQuantity);
    }

    // Getters and Setters

    public Map<Medicament, Integer> getMedicaments() {
        return medicaments;
    }

    public void setMedicaments(Map<Medicament, Integer> medicaments) {
        this.medicaments = medicaments;
    }

    public Integer getPickupCode() {
        return pickupCode;
    }

    public void deletePickupCode(Integer code) {
        pickupCodesList.remove(code);
    }

    public void setPickupCode(Integer pickupCode) {
        this.pickupCode = pickupCode;
    }

    public Staff getIssuingDoctor() {
        return issuingDoctor;
    }

    public void setIssuingDoctor(Staff issuingDoctor) {
        this.issuingDoctor = issuingDoctor;
    }

    public String getExpirationDate() {
        return DATE_FORMAT.format(expirationDate);
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public static List<Integer> getPickupCodesList() {
        return pickupCodesList;
    }

    public String toString()
    {
        return("ID:"+id+" "+"Recepta wystawiona: " + DATE_FORMAT.format(date)+" Przez: "+ issuingDoctor.getName());
    }

    @Override
public void removeObject(Boolean downCounter) {
    ObservableList<Patient> patients = HospitalEntity.filterAndConvertToObservableList(App.listOfObjects, Patient.class);
    for (Patient patient : patients) {
        if (patient.getPrescriptions().contains(this)) {
            Prescription p = this;
            patient.getPrescriptions().remove(p);
        }
    }
    super.removeObject(downCounter);
}
}
