package com.hospital;
import com.hospital.Appointments.Appointment;
import com.hospital.Medicaments_and_Equipment.Prescription;
import com.hospital.Space_Availability.Bed;
import com.hospital.Space_Availability.Department;
import com.hospital.Space_Availability.Room;
import com.hospital.Staff_and_patients.Patient;
import com.hospital.Staff_and_patients.Staff;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;

public class ListOfObjectsController {

    Staff staff;

    @FXML
    private ListView<HospitalEntity> listOfObjects;

    @FXML
    private ComboBox<Object> sortObjects;

    @FXML
    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    FilteredList<HospitalEntity> filteredItems = new FilteredList<>(FXCollections.observableList(App.listOfObjects), entity -> true); // Początkowo pokazujemy wszystko

    public void initialize(Staff staff){
        this.staff = staff;
        listOfObjects.setItems(FXCollections.observableList(App.listOfObjects));
        sortObjects.setItems(FXCollections.observableArrayList("Wszystko","Pacjenci", "Pracownicy", "Łóżka", "Pokoje", "Departamenty", "Recepty", "Wizyty"));
        sortObjects.setValue("Wszystko");
        listOfObjects.setItems(filteredItems);
        
       

        // Dodajemy listener do ComboBox, aby filtrować na podstawie wybranego typu
        sortObjects.valueProperty().addListener((observable, oldValue, newValue) -> {
            filteredItems.setPredicate(item -> {
                if (newValue.equals("Pacjenci")) {
                    return item instanceof Patient;
                } else if (newValue.equals("Pracownicy")) {
                    return item instanceof Staff;
                } else if (newValue.equals("Łóżka")) {
                    return item instanceof Bed;
                } else if (newValue.equals("Pokoje")) {
                    return item instanceof Room;
                } else if (newValue.equals("Departamenty")) {
                    return item instanceof Department;
                } else if (newValue.equals("Recepty")) {
                    return item instanceof Prescription;
                } else if (newValue.equals("Wizyty")) {
                    return item instanceof Appointment;
                }
                return true; // Jeśli wybrano "Wszystko", pokazujemy wszystkie elementy
            });
        });
        

        listOfObjects.setCellFactory(listView -> new ListCell<>() {
            @Override
            protected void updateItem(HospitalEntity item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setContextMenu(null);
                } else {
                    setText(item.toString());

                    // Create a context menu
                    ContextMenu contextMenu = new ContextMenu();

                    // "Remove" menu item
                    MenuItem removeItem = new MenuItem("Usuń");
                        removeItem.setOnAction(event -> removeObject(item));
                        contextMenu.getItems().add(removeItem);
                        setContextMenu(contextMenu);
                }
            }
        });
    }
    

    public void removeObject(HospitalEntity item){
        try{
            if(item!=staff) item.removeObject(false);
            else showAlert("Błąd", "Nie możesz usunąć samego siebie", Alert.AlertType.ERROR);
            backMenu();
        }
        catch (IllegalStateException e) {
            showAlert("Błąd", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void backMenu() {
        mainController.backToMenuScreen(staff);
    }

    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}