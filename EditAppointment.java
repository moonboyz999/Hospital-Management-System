package com.Techcare.TechCare;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class EditAppointment extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Edit Appointment");

        // Create UI components
        Label appointmentIdLabel = new Label("Appointment ID:");
        TextField appointmentIdField = new TextField();

        Label patientNameLabel = new Label("Patient Name:");
        TextField patientNameField = new TextField();

        Label doctorNameLabel = new Label("Doctor Name:");
        TextField doctorNameField = new TextField();

        Label appointmentDateLabel = new Label("Appointment Date:");
        DatePicker appointmentDatePicker = new DatePicker();

        Button editAppointmentButton = new Button("Edit Appointment");

        // Layout using GridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        // Adding components to the grid
        gridPane.add(appointmentIdLabel, 0, 0);
        gridPane.add(appointmentIdField, 1, 0);
        gridPane.add(patientNameLabel, 0, 1);
        gridPane.add(patientNameField, 1, 1);
        gridPane.add(doctorNameLabel, 0, 2);
        gridPane.add(doctorNameField, 1, 2);
        gridPane.add(appointmentDateLabel, 0, 3);
        gridPane.add(appointmentDatePicker, 1, 3);
        gridPane.add(editAppointmentButton, 1, 4);

        // Set action for Edit button
        editAppointmentButton.setOnAction(e -> {
            String appointmentId = appointmentIdField.getText();
            String patientName = patientNameField.getText();
            String doctorName = doctorNameField.getText();
            String appointmentDate = (appointmentDatePicker.getValue() != null) ? appointmentDatePicker.getValue().toString() : "";

            if (appointmentId.isEmpty() || patientName.isEmpty() || doctorName.isEmpty() || appointmentDate.isEmpty()) {
                showAlert(AlertType.ERROR, "Error", "All fields are required!");
            } else {
                // Edit appointment logic
                showAlert(AlertType.INFORMATION, "Success", "Appointment " + appointmentId + " updated successfully!");
            }
        });

        // Create the scene and add it to the stage
        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to display alerts
    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
