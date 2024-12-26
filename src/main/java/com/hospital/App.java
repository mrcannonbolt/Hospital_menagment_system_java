package com.hospital;

import com.hospital.Appointments.AppointmentManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.hospital.Medicaments_and_Equipment.Medicament;
import com.hospital.Medicaments_and_Equipment.Prescription;
import com.hospital.Medicaments_and_Equipment.TypeOfMedicament;
import com.hospital.Space_Availability.Bed;
import com.hospital.Space_Availability.Department;
import com.hospital.Space_Availability.Room;
import com.hospital.Staff_and_patients.Gender;
import com.hospital.Staff_and_patients.LoginSystem;
import com.hospital.Staff_and_patients.Patient;
import com.hospital.Staff_and_patients.PatientStatus;
import com.hospital.Staff_and_patients.Staff;
import com.hospital.Staff_and_patients.StaffPositions;

public class App extends Application{

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("MainScene.fxml"));
        StackPane stackPane = fxmlLoader.load();
        Scene scene = new Scene(stackPane, 900, 600);
        stage.setTitle("Aplikacja szpitala");
        stage.setScene(scene);
        stage.show();
        try
        {
            Staff rescuer1 = new Staff(1,"Zbysiu",Gender.MAN,"62745428357",LocalDate.of(2002,7,23), StaffPositions.RESCUER,"qwerty123","qwerty123");
            Staff doctor1 = new Staff(1,"Dr. House",Gender.MAN,"62747357357", LocalDate.of(2000,4,23), StaffPositions.DOCTOR,"qwerty","qwerty");
            Staff admin1 = new Staff(1,"ADMIN",Gender.MAN,"66666666666",LocalDate.of(1999,4,12),StaffPositions.IT_ADMIN,"qwerty1","qwerty1");
            AppointmentManager.getInstance().addStaffMember(rescuer1);
            AppointmentManager.getInstance().addStaffMember(doctor1);
            AppointmentManager.getInstance().addStaffMember(admin1);
            LoginSystem loginSystem = LoginSystem.getInstance();
            loginSystem.registerStaff(doctor1);
            loginSystem.registerStaff(rescuer1);
            loginSystem.registerStaff(admin1);
            Medicament med1= new Medicament(2, "Apap extra", TypeOfMedicament.TABLETS);
            Medicament med2= new Medicament(3, "Ibuprom", TypeOfMedicament.INJECTION);


            Map<Medicament, Integer> medicamentMap = new HashMap<>();
            medicamentMap.put(med1, 2);
            medicamentMap.put(med2, 1);

            Patient marek = new Patient(1, "Marek", Gender.MAN,LocalDate.now(),"12221323232", PatientStatus.CRITICAL_CONDITION);
            AppointmentManager.getInstance().addPatient(marek);
            Prescription prescription1 = new Prescription(0, "precsription1", doctor1, medicamentMap);
            marek.addPrescription(prescription1);
            marek.displayInfo();
            marek.getPrescriptions();
            doctor1.displayInfo();
            AppointmentManager appointmentManager = AppointmentManager.getInstance();
            appointmentManager.bookAppointment(doctor1,marek, LocalDateTime.of(2024,12,26,10,30),"Wizyta kontrolna");
            appointmentManager.bookAppointment(doctor1,marek, LocalDateTime.of(2024,12,26,10,31),"Wizyta kontrolna");
            appointmentManager.getAllAppointments();
            /////////////////////////////////// testy sale ///////////////////////////////////////////////
            Bed bed1= new Bed(1,"1");
            Bed bed2= new Bed(2,"2");
            Bed bed3= new Bed(3,"3");

            Room room1 = new Room(1, "101");
            Room room2 = new Room(2,"102");
            Department department1 = new Department(1, "Kardiologia");

            department1.addRoom(room1);
            department1.addRoom(room2);
            room1.addBed(bed1);
            room1.addBed(bed2);
            room2.addBed(bed3);
            bed1.assignPatient(marek);

            System.out.println("\n");
            department1.displayInfo();

        }
        catch (IllegalArgumentException e)
        {
            System.out.println("dupa");
        }
    }

    public static void main(String[] args) {
        launch();
    }
}