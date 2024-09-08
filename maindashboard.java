package com.Techcare.TechCare;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class MainDashboard extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Main Dashboard");

        // Create buttons for dashboard actions
        Button addAppointmentButton = new Button("Add Appointment");
        Button billingButton = new Button("Billing");
        Button editAppointmentButton = new Button("Edit Appointment");

        // Set actions for each button (Navigating to different windows)
        addAppointmentButton.setOnAction(e -> {
            AddAppointment addAppointment = new AddAppointment();
            addAppointment.start(new Stage());
        });

        billingButton.setOnAction(e -> {
            Billing billing = new Billing();
            billing.start(new Stage());
        });

        editAppointmentButton.setOnAction(e -> {
            EditAppointment editAppointment = new EditAppointment();
            editAppointment.start(new Stage());
        });

        VBox vbox = new VBox(10, addAppointmentButton, billingButton, editAppointmentButton);
        vbox.setPadding(new Insets(10));

        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}