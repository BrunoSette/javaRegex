package com.example.regex;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.regex.Pattern;

public class HelloController {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField contactNumberField;

    @FXML
    private TextField postalCodeField;

    @FXML
    private Label outputLabel;

    @FXML
    public void onSubmitButtonClicked() {
        String username = usernameField.getText();
        String contactNumber = contactNumberField.getText();
        String postalCode = postalCodeField.getText();

        StringBuilder validationResults = new StringBuilder();

        // Validate username
        if (!Pattern.matches("^[A-Z][a-zA-Z]*$", username)) {
            validationResults.append("Invalid Username. It should start with an uppercase letter followed by letters.\n");
        }

        // Validate contact number
        if (!Pattern.matches("^\\d{10}$", contactNumber) &&
                !Pattern.matches("^\\(\\d{3}\\) \\d{3} \\d{4}$", contactNumber) &&
                !Pattern.matches("^\\d{3} \\d{3} \\d{4}$", contactNumber)) {
            validationResults.append("Invalid Contact Number. It should be 10 digits long in the format XXX XXX XXXX or (XXX) XXX XXXX.\n");
        }

        // Validate postal code
        if (!Pattern.matches("^[A-Za-z]\\d[A-Za-z][ -]?\\d[A-Za-z]\\d$", postalCode)) {
            validationResults.append("Invalid Postal Code. Acceptable formats: P6R 2V8, P6r-2V8, p6r 2v8, p6r-2v8.\n");
        }

        if (validationResults.length() == 0) {
            validationResults.append("All inputs are valid!");
        }

        outputLabel.setText(validationResults.toString());
    }
}
