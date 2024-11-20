package com.hospital;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;

public class Prescription extends HospitalEntity {

    private Map<Medicament, Integer> medicaments;
    private List<Integer> pickup_codes_list= new ArrayList<>();
    private Integer pickup_code;
    private Staff issuingDoctor;
    private Date expiration_date;

    public Prescription(int id, String name, Staff issuingDoctor, Map<Medicament, Integer> medicaments) {
        super(id, name);
        this.medicaments = medicaments;
        this.issuingDoctor = issuingDoctor;
        this.expiration_date = calculateExpirationDate(date, 60);
        this.pickup_code = assignPickupCode();
    }

    private Date calculateExpirationDate(Date date, int days_to_add) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, days_to_add);
        return calendar.getTime();
    }

    private Integer assignPickupCode() {
        Integer assign_number;
        do
        {
            assign_number=ThreadLocalRandom.current().nextInt(100000, 999999);
        }
        while(pickup_codes_list.contains(assign_number));
        return assign_number;
    }

    public void displayInfo() {
        System.out.println("\n" +"Doktor wystawiający: " + issuingDoctor);
        System.out.println("Data wystawienia: " + DATE_FORMAT.format(date));
        System.out.println("Data ważności recepty: " + DATE_FORMAT.format(expiration_date));
        System.out.println("Kod odbioru: "+ pickup_code);
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
