module com.example.threadracing {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.threadracing to javafx.fxml;
    exports com.example.threadracing;
}