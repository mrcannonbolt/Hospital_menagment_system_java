package com.hospital;

import com.hospital.Staff_and_patients.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class StaffManagementController {

    private int lastId=3;

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
    private Staff staff;

    @FXML
    public void setUser(Staff staff) {
        this.staff=staff;
    }

    @FXML
    public int idGenerator() {
        lastId+=1;
        return lastId;
    }

    @FXML
    public void initialize() {
        staffPosition.getItems().addAll(StaffPositions.values());
        staffGender.getItems().addAll(Gender.values());
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
    }

    @FXML
    public void backMenu() {
        mainController.backToMenuScreen(staff);
    }
    @FXML
    public void addStaff() {
        if(staffUserSystem.isSelected()) addStaffAndRegister();
        else{
            String name = staffName.getText();
            String pesel = staffPesel.getText();
            Gender gender = staffGender.getValue();
            LocalDate birthDate = staffDate.getValue();
            StaffPositions position = staffPosition.getValue();
            String login = staffLogin.getText();
            String password = staffPassword.getText();
            if (name.isEmpty() || pesel.isEmpty() || gender == null || birthDate == null || position == null || login.isEmpty() || password.isEmpty()) {
                showAlert("Błąd", "Wszystkie pola muszą być wypełnione.", Alert.AlertType.ERROR);
                return;
            }
            try {
            Staff newStaff = new Staff(idGenerator(),name,gender,pesel,birthDate,position,login,password);
            App.listOfObjects.add(newStaff);
            showAlert("Sukces","Pracownik dodany:\n" + newStaff, Alert.AlertType.INFORMATION);
            } catch (IllegalArgumentException e) {
                // Obsługa błędów walidacji PESEL
                showAlert("Błąd", e.getMessage(), Alert.AlertType.ERROR);
            }
        }
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
            showAlert("Błąd", "Wszystkie pola muszą być wypełnione.", Alert.AlertType.ERROR);
            return;
        }
        Staff newStaff = new Staff(idGenerator(),name,gender,pesel,localDate,position,login,password);
        App.listOfObjects.add(newStaff);
        LoginSystem loginSystem = LoginSystem.getInstance();
        loginSystem.registerStaff(newStaff);
        showAlert("Sukces","Pracownik dodany i zarejestrowany w systemie:\n" + newStaff, Alert.AlertType.INFORMATION);
    }

    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
