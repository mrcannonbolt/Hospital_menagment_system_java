package com.hospital;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    static public List<HospitalEntity> listOfObjects = new ArrayList<>();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("MainScene.fxml"));
        StackPane stackPane = fxmlLoader.load();
        Scene scene = new Scene(stackPane, 1000, 600);
        stage.setTitle("Aplikacja szpitala");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        try
        {
            Staff rescuer1 = new Staff("Zbysiu",Gender.MAN,"62745428357",LocalDate.of(2002,7,23), StaffPositions.RESCUER,"qwerty123","qwerty123");
            Staff doctor1 = new Staff("Dr. House",Gender.MAN,"62747357357", LocalDate.of(2000,4,23), StaffPositions.DOCTOR,"qwerty","qwerty");
            Staff admin1 = new Staff("ADMIN",Gender.MAN,"66666666666",LocalDate.of(1999,4,12),StaffPositions.IT_ADMIN,"qwerty1","qwerty1");
            LoginSystem loginSystem = LoginSystem.getInstance();
            loginSystem.registerStaff(doctor1);
            loginSystem.registerStaff(rescuer1);
            loginSystem.registerStaff(admin1);
            Medicament med1 = new Medicament("Paracetamol", TypeOfMedicament.TABLETS);
            Medicament med2 = new Medicament("Ibuprofen", TypeOfMedicament.CAPSULES);
            Medicament med3 = new Medicament("Ambroksol", TypeOfMedicament.SYRUP);
            Medicament med4 = new Medicament("Hydrokortyzon", TypeOfMedicament.OINTMENT);
            Medicament med5 = new Medicament("Diklofenak", TypeOfMedicament.GEL);
            Medicament med6 = new Medicament("Amoksycylina", TypeOfMedicament.SUSPENSION);
            Medicament med7 = new Medicament("Salbutamol", TypeOfMedicament.AEROSOL);
            Medicament med8 = new Medicament("Metronidazol", TypeOfMedicament.INJECTION);
            Medicament med9 = new Medicament("Bisakodyl", TypeOfMedicament.SUPPOSITORIES);
            Medicament med10 = new Medicament("Omeprazol", TypeOfMedicament.GRANULES);
            Medicament med11 = new Medicament("Ketoprofen", TypeOfMedicament.GEL);
            Medicament med12 = new Medicament("Magnez", TypeOfMedicament.TABLETS);
            Medicament med13 = new Medicament("Klemastyna", TypeOfMedicament.SYRUP);
            Medicament med14 = new Medicament("Furosemid", TypeOfMedicament.INJECTION);
            Medicament med15 = new Medicament("Witamina C", TypeOfMedicament.GRANULES);

            Map<Medicament, Integer> medicamentMap = new HashMap<>();

            Patient p1 = new Patient("Marek", Gender.MAN,LocalDate.now(),"12221323232", PatientStatus.CRITICAL_CONDITION);
            Patient p2 = new Patient("Mirek", Gender.MAN,LocalDate.now(),"12221323232", PatientStatus.IMPROVING_CONDITION);
            Patient p3 = new Patient("Mariusz", Gender.MAN,LocalDate.now(),"12221323232", PatientStatus.IMPROVING_CONDITION);

            Prescription prescription1 = new Prescription("precsription1", doctor1, medicamentMap);
            p1.addPrescription(prescription1);
            /////////////////////////////////// testy sale ///////////////////////////////////////////////
            Bed bed1= new Bed("1");
            Bed bed2= new Bed("2");
            Bed bed3= new Bed("3");
            Bed bed4= new Bed("4");
            Bed bed5= new Bed("5");

            Room room1 = new Room("101");
            Room room2 = new Room("102");
            Room room3 = new Room("103");
            Department department1 = new Department("Kardiologia");
            Department department2 = new Department("Chirurgia");

            department1.addRoom(room1);
            department1.addRoom(room2);
            department2.addRoom(room3);
            room1.addBed(bed1);
            room1.addBed(bed2);
            room2.addBed(bed3);
            room3.addBed(bed4);
            room3.addBed(bed5);
            bed1.assignPatient(p1);
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