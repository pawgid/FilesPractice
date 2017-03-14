package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private Button submit;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField loginTextField;

    @FXML
    void submitOnAction(ActionEvent event) {
        System.out.println(loginTextField.getText());
        System.out.println(passwordField.getText());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Hello world");
        alert.show();
        //1. Powolac do zycia user service
        //2. Tworzenie uzytkownika z polami pobrany z fieldow
        //3. Korzystamy z metody authenticate
        //4. Sprawdzenie czy haslo jest ok (if)
        //5. Nieprawidlowe haslo to alert (warning)
    }
}

