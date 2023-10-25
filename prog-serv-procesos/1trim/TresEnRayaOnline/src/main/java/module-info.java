module com.example.tresenrayaonline {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tresenrayaonline to javafx.fxml;
    exports com.example.tresenrayaonline;
}