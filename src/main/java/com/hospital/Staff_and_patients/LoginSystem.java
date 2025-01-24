package com.hospital.Staff_and_patients;

import java.util.HashMap;
import java.util.Map;

public class LoginSystem {

    // Statyczna instancja klasy
    private static final LoginSystem instance = new LoginSystem();

    private Map<String, Staff> staffAccounts = new HashMap<>();

    public void registerStaff(Staff staff) {
        if (staffAccounts.containsKey(staff.getLogin())) {
            staff = null;
            throw new IllegalArgumentException("Login jest zajęty");
        }
        staffAccounts.put(staff.getLogin(), staff);
    }
    

    public Staff login(String loginAttempt,String password) 
    {
        Staff staff = null;
        if(staffAccounts.containsKey(loginAttempt))
        {
            if(staffAccounts.get(loginAttempt).authorization(password))
            {
                staff = staffAccounts.get(loginAttempt);
                return staff;
            }
            return null;
        }
    return null;
    }

    public void removeAccount(String account){
        staffAccounts.remove(account);
    }

    public static LoginSystem getInstance() 
    {
            return instance;
    }
}