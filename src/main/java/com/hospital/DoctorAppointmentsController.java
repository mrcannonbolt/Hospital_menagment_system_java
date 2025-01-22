package com.hospital;

import com.hospital.Appointments.Appointment;
import com.hospital.Appointments.AppointmentManager;
import com.hospital.Staff_and_patients.Staff;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.time.LocalDate;
import java.util.List;

public class DoctorAppointmentsController {
    private MainController mainController;

    @FXML
    private TableView<Appointment> appointmentsTable;
    @FXML
    private TableColumn<Appointment, String> patientColumn;
    @FXML
    private TableColumn<Appointment, String> dateColumn;
    @FXML
    private TableColumn<Appointment, String> descriptionColumn;

    private AppointmentManager appointmentManager;
    private Staff loggedInDoctor;

    public void initialize() {
        // Ustawienia kolumn
        patientColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getPatient().getName()));
        dateColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDateTime().toString()));
        descriptionColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDescription()));
    }

    public void setData(AppointmentManager appointmentManager, Staff loggedInDoctor) {
        this.appointmentManager = appointmentManager;
        this.loggedInDoctor = loggedInDoctor;
        refreshAppointments();
    }

    @FXML
    private void refreshAppointments() {
        List<Appointment> todayAppointments = appointmentManager.getAppointmentsForDoctorOnDate(loggedInDoctor, LocalDate.now());
        appointmentsTable.setItems(FXCollections.observableArrayList(todayAppointments));
    }

    @FXML
    public void backMenu() {
        mainController.backToMenuScreen(loggedInDoctor);
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
