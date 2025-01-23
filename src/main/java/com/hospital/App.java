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

    static public List<Object> listOfObjects = new ArrayList<>();

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
            Staff rescuer1 = new Staff(1,"Zbysiu",Gender.MAN,"62745428357",LocalDate.of(2002,7,23), StaffPositions.RESCUER,"qwerty123","qwerty123");
            Staff doctor1 = new Staff(2,"Dr. House",Gender.MAN,"62747357357", LocalDate.of(2000,4,23), StaffPositions.DOCTOR,"qwerty","qwerty");
            Staff admin1 = new Staff(3,"ADMIN",Gender.MAN,"66666666666",LocalDate.of(1999,4,12),StaffPositions.IT_ADMIN,"","");
            LoginSystem loginSystem = LoginSystem.getInstance();
            loginSystem.registerStaff(doctor1);
            loginSystem.registerStaff(rescuer1);
            loginSystem.registerStaff(admin1);
            Medicament med1 = new Medicament(1, "Paracetamol", TypeOfMedicament.TABLETS);
            Medicament med2 = new Medicament(2, "Ibuprofen", TypeOfMedicament.CAPSULES);
            Medicament med3 = new Medicament(3, "Ambroksol", TypeOfMedicament.SYRUP);
            Medicament med4 = new Medicament(4, "Hydrokortyzon", TypeOfMedicament.OINTMENT);
            Medicament med5 = new Medicament(5, "Diklofenak", TypeOfMedicament.GEL);
            Medicament med6 = new Medicament(6, "Amoksycylina", TypeOfMedicament.SUSPENSION);
            Medicament med7 = new Medicament(7, "Salbutamol", TypeOfMedicament.AEROSOL);
            Medicament med8 = new Medicament(8, "Metronidazol", TypeOfMedicament.INJECTION);
            Medicament med9 = new Medicament(9, "Bisakodyl", TypeOfMedicament.SUPPOSITORIES);
            Medicament med10 = new Medicament(10, "Omeprazol", TypeOfMedicament.GRANULES);
            Medicament med11 = new Medicament(11, "Ketoprofen", TypeOfMedicament.GEL);
            Medicament med12 = new Medicament(12, "Magnez", TypeOfMedicament.TABLETS);
            Medicament med13 = new Medicament(13, "Klemastyna", TypeOfMedicament.SYRUP);
            Medicament med14 = new Medicament(14, "Furosemid", TypeOfMedicament.INJECTION);
            Medicament med15 = new Medicament(15, "Witamina C", TypeOfMedicament.GRANULES);

            Map<Medicament, Integer> medicamentMap = new HashMap<>();

            Patient p1 = new Patient(1, "Marek", Gender.MAN,LocalDate.now(),"12221323232", PatientStatus.CRITICAL_CONDITION);
            Patient p2 = new Patient(2, "Mirek", Gender.MAN,LocalDate.now(),"12221323232", PatientStatus.IMPROVING_CONDITION);
            Patient p3 = new Patient(3, "Mariusz", Gender.MAN,LocalDate.now(),"12221323232", PatientStatus.IMPROVING_CONDITION);

            Prescription prescription1 = new Prescription(0, "precsription1", doctor1, medicamentMap);
            p1.addPrescription(prescription1);
            p1.getPrescriptions();
            AppointmentManager appointmentManager = AppointmentManager.getInstance();
            appointmentManager.bookAppointment(doctor1,p1, LocalDateTime.of(2024,12,26,10,30),"Wizyta kontrolna");
            appointmentManager.bookAppointment(doctor1,p1, LocalDateTime.of(2024,12,26,10,31),"Wizyta kontrolna");
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
            bed1.assignPatient(p1);

            System.out.println("\n");

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