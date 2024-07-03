module com.example.regex {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.regex to javafx.fxml;
    exports com.example.regex;
}