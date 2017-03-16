package controller;

import javafx.scene.control.Alert;

public class Controller {

    protected void showErrorAlert(String message) {
        showAlert(Alert.AlertType.ERROR, message);
    }

    protected void showConfirmationAlert(String message) {
        showAlert(Alert.AlertType.CONFIRMATION, message);
    }

    private void showAlert(Alert.AlertType alertType, String message) {
        new Alert(alertType, message).show();
    }
}
