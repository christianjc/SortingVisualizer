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

        // Create a scene object
        Scene scene = new Scene(root,800, 600);

        // Get the styleSheet and add the to the scene object
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/com/sortingvisualizer/view/style.css")).toExternalForm()); // Add the stylesheet


        // Set the window title
        primaryStage.setTitle("Sorting Algorithm Visualizer");

        // Create and set the Scene
        primaryStage.setScene(scene); // Adjust the size as needed

        // Show the primary stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }
}
