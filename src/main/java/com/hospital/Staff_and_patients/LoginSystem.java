package com.hospital.Staff_and_patients;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginSystem {

    private Map<String, Staff> staffAccounts = new HashMap<>();

    public void registerStaff(Staff staff) {
        staffAccounts.put(staff.getLogin(), staff);
    }

    public Staff login() 
    {
        Scanner scanner = new Scanner(System.in);
        Staff staff = null;

        while (true) {
            System.out.print("Podaj login: ");
            String login = scanner.nextLine();

            System.out.print("Podaj hasło: ");
            String password = scanner.nextLine();

            staff = staffAccounts.get(login);

            if (staff != null && staff.authorization(password)) {
                System.out.println("Zalogowano pomyślnie jako: " + staff.getName());
                break;
            } else {
                System.out.println("Nieprawidłowy login lub hasło. Spróbuj ponownie.");
            }
        }
        return staff;
    }
}