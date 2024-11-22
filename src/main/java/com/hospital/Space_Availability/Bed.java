package com.hospital.Space_Availability;

import com.hospital.HospitalEntity;
import com.hospital.Staff_and_patients.Patient;

public class Bed extends HospitalEntity{

    private Patient current_patient=null;

    public Bed(int id,String name)
    {
        super(id,name);

    }

    @Override
    public void displayInfo()
    {
        System.out.println("numer:"+name+"\n"+
        "aktualny pacjent: "+current_patient);
    }

    @Override
    public String toString() {
        if(current_patient==null)
        {
            return name+": wolne"; 
        }
        return name+": "+current_patient;
    }

    public void assignPatient(Patient patient) {
        if (current_patient!=null) {
            throw new IllegalStateException("Bed is already occupied");
        }
        this.current_patient = patient;
    }

    public void releaseBed() {
        if (current_patient!=null) {
            throw new IllegalStateException("Bed is already free");
        }
        this.current_patient = null;
    }
}
