package com.hospital;

import com.hospital.Staff_and_patients.Staff;

import javafx.fxml.FXML;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.collections.FXCollections;

public class ListOfObjectsController {

    Staff staff;

    @FXML
    private ListView<HospitalEntity> listOfObjects;

    @FXML
    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void initialize(Staff staff){
        this.staff = staff;
        listOfObjects.setItems(FXCollections.observableList(App.listOfObjects));

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
        item.removeObject(false);
        listOfObjects.setItems(FXCollections.observableList(App.listOfObjects));
    }

    @FXML
    public void backMenu() {
        mainController.backToMenuScreen(staff);
    }

}
