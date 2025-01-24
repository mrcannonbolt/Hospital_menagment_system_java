package com.hospital.Appointments;

import com.hospital.Staff_and_patients.Patient;
import com.hospital.Staff_and_patients.Staff;

import javafx.scene.control.Alert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentManager {

    private static AppointmentManager instance = null;

    private List<Appointment> appointments;


    private AppointmentManager() {
        appointments = new ArrayList<>();
    }

    public static AppointmentManager getInstance() {
        if (instance == null) {
            instance = new AppointmentManager();
        }
        return instance;
    }

    public boolean bookAppointment(Staff doctor, Patient patient, LocalDateTime dateTime, String description) {
        
                // Sprawdzanie, czy termin jest już zajęty
            for (Appointment appointment : appointments) {
                if (appointment.getDoctor().equals(doctor) && appointment.getDateTime().equals(dateTime)) {
                    return false; // Termin zajęty
                }
            }
            // Dodanie nowej wizyty
            String name =null;
            Appointment newAppointment = new Appointment(name,doctor, patient, dateTime, description);
            appointments.add(newAppointment);
            return true;
    }

    public List<Appointment> getAppointmentsForDoctorOnDate(Staff doctor, LocalDate date) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (appointment.getDoctor().equals(doctor) &&
                    appointment.getDateTime().toLocalDate().equals(date)) {
                result.add(appointment);
            }
        }
        return result;
    }

    public List<Appointment> getAllAppointments() {
        return appointments;
    }
}