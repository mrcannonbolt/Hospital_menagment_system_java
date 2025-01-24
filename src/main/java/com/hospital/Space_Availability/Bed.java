package com.hospital.Space_Availability;

import com.hospital.HospitalEntity;
import com.hospital.Staff_and_patients.Patient;

public class Bed extends HospitalEntity{

    private Patient currentPatient;

    public Bed(String name)
    {
        super(name);
        currentPatient=null;
    }

    public Bed(String name,Patient currentPatient)
    {
        super(name);
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
            return "ID:"+id+" Łóżko nr: "+name+": wolne"; 
        }
        return "ID:"+id+" Łóżko Nr: "+name+": Zajęte Pacjent: "+currentPatient.getName();
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
