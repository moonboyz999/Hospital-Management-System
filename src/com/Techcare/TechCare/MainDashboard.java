package com.Techcare.TechCare;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;

// Import the necessary classes
import com.Techcare.TechCare.AddAppointment;
import com.Techcare.TechCare.Billing;
import com.Techcare.TechCare.EditAppointment;

public class MainDashboard extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/maindashboard.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Main Dashboard");

        // Create buttons for dashboard actions
        Button addAppointmentButton = new Button("Add Appointment");
        Button billingButton = new Button("Billing");
        Button editAppointmentButton = new Button("Edit Appointment");

        // Set actions for each button (Navigating to different windows)
        addAppointmentButton.setOnAction(e -> {
            try {
                AddAppointment addAppointment = new AddAppointment();
                addAppointment.start(new Stage()); // This will open the Add Appointment window
            } catch (Exception ex) {
                ex.printStackTrace();
                showAlert(Alert.AlertType.ERROR, "Error", "Failed to open Add Appointment window");
            }
        });

        billingButton.setOnAction(e -> {
            try {
                Billing billing = new Billing();
                billing.start(new Stage()); // This will open the Billing window
            } catch (Exception ex) {
                ex.printStackTrace();
                showAlert(Alert.AlertType.ERROR, "Error", "Failed to open Billing window");
            }
        });

        editAppointmentButton.setOnAction(e -> {
            try {
                EditAppointment editAppointment = new EditAppointment();
                editAppointment.start(new Stage()); // This will open the Edit Appointment window
            } catch (Exception ex) {
                ex.printStackTrace();
                showAlert(Alert.AlertType.ERROR, "Error", "Failed to open Edit Appointment window");
            }
        });

        VBox vbox = new VBox(10, addAppointmentButton, billingButton, editAppointmentButton);
        vbox.setPadding(new Insets(10));

        // Add VBox to the Scene and set the Scene to the Stage
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to display alerts
    private void showAlert(Alert.AlertType alertType, String title, String message) {
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
