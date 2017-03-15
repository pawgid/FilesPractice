package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.Address;
import model.Company;

public class CompanyCreateController {

    @FXML
    private TextField streetField;

    @FXML
    private TextField houseNumberField;

    @FXML
    private TextField cityField;

    @FXML
    private RadioButton streetRadio;

    @FXML
    private Button addCompanyButton;

    @FXML
    private TextField flatNumberField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField zipCodeField;

    @FXML
    private RadioButton avenueRadio;

    @FXML
    private RadioButton squareRadio;

    @FXML
    private TextField nipField;


    private Address.streetPrefix streetPrefix;


    @FXML
    void choosePrefixOnAction(ActionEvent event) {
        if (event.getSource() instanceof RadioButton) {
            RadioButton currentPrefixRadioButton = (RadioButton) event.getSource();
            String buttonName = currentPrefixRadioButton.getText();
            switch (buttonName) {
                case "Ulica":
                    streetPrefix = Address.streetPrefix.STREET;
                    break;
                case "Aleja":
                    streetPrefix = Address.streetPrefix.AVENUE;
                    break;
                case "Plac":
                    streetPrefix = Address.streetPrefix.SQUARE;

            }
        }
    }

    @FXML
    void addCompanyOnAction(ActionEvent event) {
        Company company = new Company();
        company.setName(nameField.getText());
        Address address = new Address();
        address.setCity(cityField.getText());
        address.setFlatNumber(flatNumberField.getText());
        address.setHouseNumber(houseNumberField.getText());
        address.setPostalCode(zipCodeField.getText());
        address.setStreetName(streetField.getText());
        company.setAddress(address);
        company.setNip(nipField.getText());
        System.out.println(company);

    }

    @FXML
    void initialize() {
        ToggleGroup group = new ToggleGroup();
        streetRadio.setToggleGroup(group);
        squareRadio.setToggleGroup(group);
        avenueRadio.setToggleGroup(group);

    }
}


