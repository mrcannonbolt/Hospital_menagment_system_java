package com.hospital;

import com.hospital.Appointments.AppointmentManager;
import com.hospital.Staff_and_patients.Patient;
import com.hospital.Staff_and_patients.Staff;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
public class BookAppointmentController {
    private MainController mainController;
    @FXML
    private ComboBox<Staff> appointStaff;
    @FXML
    private ComboBox<Patient> appointPatient;
    @FXML
    private DatePicker appointDate;
    @FXML
    private TextField appointHour;
    @FXML
    private TextArea appointDescription;

    private AppointmentManager appointmentManager;

    private Staff staff;

    public void setData(Staff staff, AppointmentManager appointmentManager, ObservableList<Staff> staffMembers, ObservableList<Patient> patients) {
        this.staff = staff;
        this.appointmentManager = appointmentManager;
        appointStaff.setItems(staffMembers);
        appointPatient.setItems(patients);
    }
    @FXML
    public void backMenu() {
        mainController.bactToMenuScreen(staff);
    }

    @FXML
    private void bookAppointment() {
        Staff doctor = appointStaff.getValue();
        Patient patient = appointPatient.getValue();
        LocalDate date = appointDate.getValue();
        String timeText = appointHour.getText();
        String description = appointDescription.getText();

        if (doctor == null || patient == null || date == null || timeText.isEmpty() || description.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Proszę uzupełnić wszystkie pola.");
            return;
        }

        try {
            LocalTime time = LocalTime.parse(timeText);
            LocalDateTime dateTime = LocalDateTime.of(date, time);

            if (appointmentManager.bookAppointment(doctor, patient, dateTime, description)) {
                showAlert(Alert.AlertType.INFORMATION, "Wizyta została pomyślnie umówiona.");
            } else {
                showAlert(Alert.AlertType.ERROR, "Nie udało się umówić wizyty. Termin zajęty.");
            }
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Nieprawidłowy format godziny. Użyj HH:mm.");
        }
    }

    private void showAlert(Alert.AlertType type, String message) {
        Alert alert = new Alert(type, message, ButtonType.OK);
        alert.showAndWait();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}