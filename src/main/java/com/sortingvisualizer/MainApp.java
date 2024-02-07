package com.sortingvisualizer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/sortingvisualizer/view/MainApp.fxml")));

        // Set the window title
        primaryStage.setTitle("Sorting Algorithm Visualizer");

        // Create and set the Scene
        primaryStage.setScene(new Scene(root, 800, 600)); // Adjust the size as needed

        // Show the primary stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }
}
