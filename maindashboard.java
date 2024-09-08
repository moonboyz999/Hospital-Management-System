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
            addAppointment.start(new Stage
