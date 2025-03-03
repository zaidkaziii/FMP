module com.example.fmp {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.fmp to javafx.fxml;
    opens com.example.fmp.controllers to javafx.fxml; // 👈 This fixes the error

    exports com.example.fmp;
    exports com.example.fmp.controllers; // 👈 This allows JavaFX to access the controllers
}
