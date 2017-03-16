package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Address;
import model.Company;
import pdf.PdfFactory;
import service.DataService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompanyCreateController extends Controller {

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
    private TextField postalCodeField;

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
        address.setPostalCode(postalCodeField.getText());
        address.setStreetName(streetField.getText());
        company.setAddress(address);
        company.setNip(nipField.getText());
        DataService dataService = new DataService();
        dataService.printOutCompanyInfo(company);
    }

    @FXML
    void initialize() {
        ToggleGroup group = new ToggleGroup();
        streetRadio.setToggleGroup(group);
        squareRadio.setToggleGroup(group);
        avenueRadio.setToggleGroup(group);
    }

    private void validatePostalCode() {
        Pattern zipPattern = Pattern.compile("(^\\d{2}-\\d{3}$)");
        Matcher zipMatcher = zipPattern.matcher(postalCodeField.getText());
        if (zipMatcher.find()) {
            String zip = zipMatcher.group(1);
            showConfirmationAlert("Wszystko OK");
        } else {
        showErrorAlert("Zle dane");
        }
    }


    @FXML
    void makePDFOnAction(ActionEvent event) {
        Company company = new Company();
        company.setName(nameField.getText());
        Address address = new Address();
        address.setCity(cityField.getText());
        address.setFlatNumber(flatNumberField.getText());
        address.setHouseNumber(houseNumberField.getText());
        address.setPostalCode(postalCodeField.getText());
        address.setStreetName(streetField.getText());
        company.setAddress(address);
        company.setNip(nipField.getText());
        DataService dataService = new DataService();
        dataService.printOutCompanyInfo(company);
        PdfFactory pdfFactory = new PdfFactory();
        pdfFactory.createPdfFromCompany(company);
    }

    @FXML
    void validateOnAction(ActionEvent event) {
        validatePostalCode();
    }
}


