package com.Techcare.TechCare;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Billing extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Billing");

        // Create UI components
        Label patientNameLabel = new Label("Patient Name:");
        TextField patientNameField = new TextField();

        Label amountLabel = new Label("Amount:");
        TextField amountField = new TextField();

        Button processBillingButton = new Button("Process Billing");

        // Layout using GridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        // Adding components to the grid
        gridPane.add(patientNameLabel, 0, 0);
        gridPane.add(patientNameField, 1, 0);
        gridPane.add(amountLabel, 0, 1);
        gridPane.add(amountField, 1, 1);
        gridPane.add(processBillingButton, 1, 2);

        // Set action for Process Billing button
        processBillingButton.setOnAction(e -> {
            String patientName = patientNameField.getText();
            String amount = amountField.getText();

            if (patientName.isEmpty() || amount.isEmpty()) {
                showAlert(AlertType.ERROR, "Error", "All fields are required!");
            } else {
                // Process billing logic
                showAlert(AlertType.INFORMATION, "Success", "Billing processed for " + patientName + " with amount " + amount);
            }
        });

        // Create the scene and add it to the stage
        Scene scene = new Scene(gridPane, 400, 200);
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
