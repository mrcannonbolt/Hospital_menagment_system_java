package com.hospital;

import com.hospital.Staff_and_patients.Gender;
import com.hospital.Staff_and_patients.LoginSystem;
import com.hospital.Staff_and_patients.Staff;
import com.hospital.Staff_and_patients.StaffPositions;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class StaffManagementController {

    private int lastId=0;

    @FXML
    private MainController mainController;

    @FXML
    private TextField staffName;

    @FXML
    private TextField staffPesel;

    @FXML
    private TextField staffLogin;

    @FXML
    private PasswordField staffPassword;

    @FXML
    private CheckBox staffUserSystem;

    @FXML
    private DatePicker staffDate;

    @FXML
    private ComboBox<StaffPositions> staffPosition;

    @FXML
    private ComboBox<Gender> staffGender;

    @FXML
    private Label LoginLabel;

    @FXML
    private Label PasswordLabel;

    @FXML
    private Button addStaffId;

    @FXML
    private Button addStaffAndRegisterId;

    @FXML
    public int idGenerator() {
        lastId+=1;
        return lastId;
    }

    @FXML
    public void initialize() {
        staffPosition.getItems().addAll(StaffPositions.values());
        staffGender.getItems().addAll(Gender.values());
        addStaffAndRegisterId.setVisible(false);
        addStaffId.setVisible(false);
        userSystemNotChecked();
    }

    @FXML
    public void userSystemChecked() {
        if (staffUserSystem.isSelected()) {
            staffLogin.setVisible(true);
            staffPassword.setVisible(true);
            LoginLabel.setVisible(true);
            PasswordLabel.setVisible(true);
            staffLogin.setText("");
            staffPassword.setText("");
            addStaffAndRegisterId.setVisible(true);
            addStaffId.setVisible(false);
        } else {
            userSystemNotChecked();
        }
    }

    public void userSystemNotChecked() {
        staffLogin.setVisible(false);
        staffPassword.setVisible(false);
        LoginLabel.setVisible(false);
        PasswordLabel.setVisible(false);
        staffLogin.setText("123");
        staffPassword.setText("123");
        addStaffId.setVisible(true);
        addStaffAndRegisterId.setVisible(false);
    }

    @FXML
    public void backMenu() {
        mainController.loadMenuScreen();
    }
    @FXML
    public void addStaff() {
        String name = staffName.getText();
        String pesel = staffPesel.getText();
        Gender gender = staffGender.getValue();
        LocalDate localDate = staffDate.getValue();
        StaffPositions position = staffPosition.getValue();
        String login = staffLogin.getText();
        String password = staffPassword.getText();
        if (name.isEmpty() || pesel.isEmpty() || gender == null || localDate == null || position == null || login.isEmpty() || password.isEmpty()) {
            System.out.println("Wszystkie pola muszą być wypełnione.");
        }
        Staff newStaff = new Staff(idGenerator(),name,gender,pesel,localDate,position,login,password);
        System.out.println("Pracownik dodany:\n" + newStaff);
    }

    @FXML
    public void addStaffAndRegister() {
        String name = staffName.getText();
        String pesel = staffPesel.getText();
        Gender gender = staffGender.getValue();
        LocalDate localDate = staffDate.getValue();
        StaffPositions position = staffPosition.getValue();
        String login = staffLogin.getText();
        String password = staffPassword.getText();
        if (name.isEmpty() || pesel.isEmpty() || gender == null || localDate == null || position == null || login.isEmpty() || password.isEmpty()) {
            System.out.println("Wszystkie pola muszą być wypełnione.");
        }
        Staff newStaff = new Staff(idGenerator(),name,gender,pesel,localDate,position,login,password);
        LoginSystem loginSystem = LoginSystem.getInstance();
        loginSystem.registerStaff(newStaff);
        System.out.println("Pracownik dodany i zarejestrowany w systemie:\n" + newStaff);
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
