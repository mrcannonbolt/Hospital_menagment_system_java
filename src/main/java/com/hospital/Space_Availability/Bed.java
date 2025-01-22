package com.hospital.Space_Availability;

import com.hospital.HospitalEntity;
import com.hospital.Staff_and_patients.Patient;

public class Bed extends HospitalEntity{

    private Patient currentPatient=null;

    public Bed(int id,String name)
    {
        super(id,name);

    }

    @Override
    public String toString() {
        if(currentPatient==null)
        {
            return name+": wolne"; 
        }
        return name+": "+currentPatient;
    }

    public void assignPatient(Patient patient) {
        if (currentPatient!=null) {
            throw new IllegalStateException("Łóżko jest zajęte");
        }
        this.currentPatient = patient;
    }

    public void releaseBed() {
        if (currentPatient!=null) {
            throw new IllegalStateException("Łóżko jest wolne");
        }
        this.currentPatient = null;
    }
}
