package com.hospital;

import com.hospital.Space_Availability.Bed;
import com.hospital.Space_Availability.Department;
import com.hospital.Space_Availability.Room;
import com.hospital.Staff_and_patients.Patient;
import com.hospital.Staff_and_patients.Staff;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class RegisterPatientInHospitalController {

    private MainController mainController;

    @FXML
    private ComboBox<Patient> registeringPatient;
    @FXML
    private ComboBox<Department> departmentPatient;
    @FXML
    private ComboBox<Room> roomPatient;
    @FXML
    private ComboBox<Bed> bedPatient;

    private Staff staff;

    @FXML
    public void setData(Staff staff) {
        this.staff=staff;
    }
    @FXML
    public void backMenu() {
        mainController.backToMenuScreen(staff);
    }
    @FXML
    public void registerPatient() {

    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

}
