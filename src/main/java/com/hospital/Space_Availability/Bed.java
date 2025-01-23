package com.hospital.Space_Availability;

import com.hospital.HospitalEntity;
import com.hospital.Staff_and_patients.Patient;

public class Bed extends HospitalEntity{

    private Patient currentPatient;

    public Bed(int id,String name)
    {
        super(id,name);
        currentPatient=null;
    }

    public Bed(int id,String name,Patient currentPatient)
    {
        super(id,name);
        this.currentPatient=currentPatient;
    }

    public Boolean isFree()
    {
        if(currentPatient==null)return true;
        return false;
    }

    @Override
    public String toString() {
        if(currentPatient==null)
        {
            return name+": wolne"; 
        }
        return name+": "+": Zajęte Pacjent: "+currentPatient.getName();
    }

    public void assignPatient(Patient patient) {
        if (currentPatient!=null) {
            throw new IllegalStateException("Łóżko jest zajęte");
        }
        this.currentPatient = patient;
        currentPatient.setAssignedBed(this);
    }

    public void releaseBed() {
        if (currentPatient==null) {
            throw new IllegalStateException("Łóżko jest puste");
        }
        currentPatient.setAssignedBed(null);
        this.currentPatient = null;
    }
}
