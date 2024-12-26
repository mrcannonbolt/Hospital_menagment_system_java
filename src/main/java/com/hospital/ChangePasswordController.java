package com.hospital;

import com.hospital.Staff_and_patients.Staff;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class ChangePasswordController {

    @FXML
    private PasswordField oldPassword;

    @FXML
    private PasswordField newPassword;

    @FXML
    private PasswordField newPassword2;

    @FXML
    private Staff staff;

    @FXML
    public void setUser(Staff staff) {
        this.staff=staff;
    }

    @FXML
    public void savePassword() {
        String oldPassInp = oldPassword.getText();
        String newPassInp = newPassword.getText();
        String newPassInp2= newPassword2.getText();

        if (!staff.authorization(oldPassInp)) {
            showAlert("Błąd", "Nieprawidłowe aktualne hasło.", Alert.AlertType.ERROR);
            return;
        }

        if (newPassInp.isEmpty() || newPassInp2.isEmpty()) {
            showAlert("Błąd", "Nowe hasło nie może być puste.", Alert.AlertType.ERROR);
            return;
        }

        if (!newPassInp.equals(newPassInp2)) {
            showAlert("Błąd", "Nowe hasło i jego potwierdzenie nie są zgodne.", Alert.AlertType.ERROR);
            return;
        }

        staff.setPassword(newPassInp);
        showAlert("Sukces", "Hasło zostało zmienione pomyślnie.", Alert.AlertType.INFORMATION);

        oldPassword.clear();
        newPassword.clear();
        newPassword2.clear();
    }

    @FXML
    public void closeWindow() {
        Stage stage = (Stage) oldPassword.getScene().getWindow();
        stage.close();
    }

    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
