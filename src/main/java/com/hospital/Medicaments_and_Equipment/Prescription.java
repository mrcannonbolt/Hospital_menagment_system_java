package com.hospital.Medicaments_and_Equipment;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;

import com.hospital.HospitalEntity;
import com.hospital.Staff_and_patients.Staff;

public class Prescription extends HospitalEntity {

    private Map<Medicament, Integer> medicaments;
    private List<Integer> pickupCodesList= new ArrayList<>();
    private Integer pickupCode;
    private Staff issuingDoctor;
    private Date expirationDate;

    public Prescription(int id, String name, Staff issuingDoctor, Map<Medicament, Integer> medicaments) {
        super(id, name);
        this.medicaments = medicaments;
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

    public void displayInfo() {
        System.out.println("\n" +"Doktor wystawiający: " + issuingDoctor);
        System.out.println("Data wystawienia: " + DATE_FORMAT.format(date));
        System.out.println("Data ważności recepty: " + DATE_FORMAT.format(expirationDate));
        System.out.println("Kod odbioru: "+ pickupCode);
        System.out.println("Lista leków na recepcie:");
        for (Map.Entry<Medicament, Integer> entry : medicaments.entrySet()) {
            Medicament medicament = entry.getKey();
            Integer quantity = entry.getValue();
            System.out.println(String.format(
                            "Nazwa leku: %s" +
                            ", Ilość: %d" +
                            ", Rodzaj leku: %s",
                    medicament.getName(), quantity, medicament.getTypeOfMedicament()
            ));
        }

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
}
