package com.example.fmp.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.example.fmp.models.Faculty;
import java.io.IOException;

public class FacultyController {

    @FXML
    private TextField nameField, emailField, departmentField;

    @FXML
    private Button saveButton;

    @FXML
    private void saveFaculty() {
        // Fetch input values
        String name = nameField.getText();
        String email = emailField.getText();
        String department = departmentField.getText();

        // Check if fields are empty
        if (name.isEmpty() || email.isEmpty() || department.isEmpty()) {
            showAlert("Error", "All fields are required!");
            return;
        }

        // Create Faculty object (in real case, you'd store this in a database)
        Faculty faculty = new Faculty(1, name, email, department);
        System.out.println("Faculty Saved: " + faculty.getName());

        // Show success message
        showAlert("Success", "Faculty saved successfully!");

        // Switch to Faculty List Scene
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/fmp/views/faculty-list.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) nameField.getScene().getWindow();
            stage.setScene(new Scene(root, 400, 300));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper method to show an alert
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
