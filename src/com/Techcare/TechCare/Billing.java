package com.Techcare.TechCare;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Billing extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Billing");

        // Create UI components
        Label patientIdLabel = new Label("Patient ID:");
        TextField patientIdField = new TextField();

        Label amountLabel = new Label("Amount:");
        TextField amountField = new TextField();

        Button processBillingButton = new Button("Process Billing");

        // Layout using GridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        // Adding components to the grid
        gridPane.add(patientIdLabel, 0, 0);
        gridPane.add(patientIdField, 1, 0);
        gridPane.add(amountLabel, 0, 1);
        gridPane.add(amountField, 1, 1);
        gridPane.add(processBillingButton, 1, 2);

        // Set action for Process Billing button
        processBillingButton.setOnAction(e -> {
            String patientId = patientIdField.getText();
            String amount = amountField.getText();

            if (patientId.isEmpty() || amount.isEmpty()) {
                showAlert(AlertType.ERROR, "Error", "All fields are required!");
            } else {
                // Billing logic
                showAlert(AlertType.INFORMATION, "Success", "Billing for patient " + patientId + " processed successfully!");
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
