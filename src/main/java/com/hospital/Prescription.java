package com.hospital;

import java.util.Date;
import java.util.Map;
import java.util.Calendar;

public class Prescription extends HospitalEntity {

    private Map<Medicament, Integer> medicaments;
    private Staff issuingDoctor;
    private Date expiration_date;

    public Prescription(int id, String name, Staff issuingDoctor, Map<Medicament, Integer> medicaments) {
        super(id, name);
        this.medicaments = medicaments;
        this.issuingDoctor = issuingDoctor;
        this.expiration_date = calculateExpirationDate(date, 60); // Obliczamy datę ważności

    }

    private Date calculateExpirationDate(Date date, int days_to_add) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, days_to_add); // Dodajemy 60 dni
        return calendar.getTime();
    }

    public void displayInfo() {
        System.out.println("Doktor wystawiający: " + issuingDoctor);
        System.out.println("Data wystawienia: " + DATE_FORMAT.format(date));
        System.out.println("Data ważności recepty: " + DATE_FORMAT.format(expiration_date));
        System.out.println("Lista leków na recepcie:");
        for (Map.Entry<Medicament, Integer> medicament : medicaments.entrySet()) {
            System.out.println(medicament.getKey() + ", Ilość: " + medicament.getValue());
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
