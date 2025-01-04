package com.hospital;

import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

import com.hospital.Medicaments_and_Equipment.Medicament;
import com.hospital.Medicaments_and_Equipment.Prescription;
import com.hospital.Medicaments_and_Equipment.PrescriptionList;
import com.hospital.Medicaments_and_Equipment.TypeOfMedicament;
import com.hospital.Staff_and_patients.Patient;
import com.hospital.Staff_and_patients.Staff;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class AddPrescriptionController {
    
    private MainController mainController;
    @FXML
    private ComboBox<Patient> prescriptionPatient;
    @FXML
    private ComboBox<Medicament> prescriptionMedicaments;
    @FXML
    private TableView<PrescriptionList> medicamentsTable;
    @FXML
    private TableColumn<PrescriptionList, Integer> IDColumn;
    @FXML
    private TableColumn<PrescriptionList, Medicament> medicamentColumn;
    @FXML
    private TableColumn<PrescriptionList, TypeOfMedicament> typeColumn;
    @FXML
    private TableColumn<PrescriptionList, Integer> countColumn;
    @FXML 
    private TextField medicamentsCount;

    private ObservableList<PrescriptionList> tableData = FXCollections.observableArrayList();

    Integer medicamentCounter;
    Prescription prescription;

    private Staff staff;

    @FXML
    private void initialize() {
        // Definiowanie wzorca dla liczb całkowitych
        Pattern validNumberPattern = Pattern.compile("\\d*");
        UnaryOperator<TextFormatter.Change> filter = change -> {
            if (validNumberPattern.matcher(change.getControlNewText()).matches()) {
                return change;
            }
            return null;
        };
        // Tworzenie TextFormatter z filtrem
        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
        medicamentsCount.setTextFormatter(textFormatter);

        IDColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        medicamentColumn.setCellValueFactory(cellData -> cellData.getValue().medicamentProperty());
        typeColumn.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
        countColumn.setCellValueFactory(cellData -> cellData.getValue().countProperty().asObject());
    
        // Powiązanie listy z tabelą
        medicamentsTable.setItems(tableData);
    }

    public void setData(Staff staff, ObservableList<Patient> patients, ObservableList<Medicament> medicaments) {
        this.staff = staff;
        prescriptionPatient.setItems(patients);
        prescriptionMedicaments.setItems(medicaments);
        medicamentCounter = 1;
        prescription = new Prescription(0, "elo", this.staff, null);
    }

    @FXML
    public void backMenu() {
        prescription.deletePickupCode(prescription.getPickupCode());
        prescription = null;
        mainController.bactToMenuScreen(staff);
    }

    @FXML
    public void addMedicament() {
        try {
            int count = Integer.parseInt(medicamentsCount.getText());
            Medicament selectedMedicament = prescriptionMedicaments.getValue();

            if (selectedMedicament != null && count > 0) {
                if(prescription.getMedicaments().containsKey(selectedMedicament)){
                    showAlert(Alert.AlertType.WARNING, "Taki lek już istnieje na recepcie");
                }
                else{
                    prescription.addMedicament(selectedMedicament, count);
                    PrescriptionList newEntry = new PrescriptionList(tableData.size() + 1,
                    selectedMedicament,
                    selectedMedicament.getTypeOfMedicament(),
                    count
                    );
                    tableData.add(newEntry);
                }

            } else {
                showAlert(Alert.AlertType.WARNING, "Podaj wartość liczbową leku");
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.WARNING, "Podaj ilość przypisywanego leku");
        }
    }

    @FXML
    public void confirmPrescription(){
        if (prescriptionPatient == null || tableData.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Proszę uzupełnić wszystkie pola.");
            return;
        }
        prescriptionPatient.getValue().addPrescription(prescription);
        mainController.bactToMenuScreen(staff);
    }

    private void showAlert(Alert.AlertType type, String message) {
        Alert alert = new Alert(type, message, ButtonType.OK);
        alert.showAndWait();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

}
