package com.hospital;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Date;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class App extends Application{

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("MainScene.fxml"));
        StackPane stackPane = fxmlLoader.load();
        Scene scene = new Scene(stackPane, 700, 700);
        stage.setTitle("Aplikacja szpitala");
        stage.setScene(scene);
        stage.show();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd");
        try
        {
            Date date1 = sdf1.parse("2001.02.02");
            Date date2 = sdf1.parse("1992.06.02");
            Staff doctor = new Staff(1,"Dr. House",Gender.MAN,"62747357357",date2, StaffPositions.DOCTOR,"qwerty","qwerty");
            LoginSystem loginSystem = new LoginSystem();
            loginSystem.registerStaff(doctor);
            Staff loggedInStaff = loginSystem.login();
            if (loggedInStaff != null) {
                loggedInStaff.displayInfo();
            }
            Medicament med1= new Medicament(2, "Apap extra", TypeOfMedicament.TABLETS);
            Medicament med2= new Medicament(3, "Ibuprom", TypeOfMedicament.INJECTION);


            Map<Medicament, Integer> medicamentMap = new HashMap<>();
            medicamentMap.put(med1, 2);
            medicamentMap.put(med2, 1);

            Patient marek = new Patient(1, "Marek", Gender.MAN,date1,"12221323232", PatientStatus.CRITICAL_CONDITION);
            Prescription prescription1 = new Prescription(0, "precsription1", doctor, medicamentMap);
            marek.addPrescription(prescription1);
            marek.displayInfo();
            marek.getPrescriptions();
            doctor.displayInfo();

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
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("dupa");
        }
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}