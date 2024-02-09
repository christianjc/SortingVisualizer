package com.sortingvisualizer.controller;

import com.sortingvisualizer.model.SortingAlgorithm;
import com.sortingvisualizer.util.SortingAlgorithmType;
import com.sortingvisualizer.view.VisualizerCanvas;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;

import java.util.Arrays;

/**
 * Controls the UI for the Sorting Visualizer application, handling user interactions,
 * and managing the visualization of different sorting algorithms.
 * <p>
 * This class is responsible for initializing the application's UI components, handling action events
 * such as starting, stopping, and resetting the sorting process, and updating the UI in response
 * to user inputs.
 * </p>
 *
 * @version 1.0
 * @author Your Name
 */
public class SortingVisualizerController {

    private static final int CANVAS_WIDTH = 800;
    private static final int CANVAS_HEIGHT = 500;
    private static final double DEFAULT_SPEED = 50;

    @FXML
    private Pane canvasContainer;

    @FXML
    private ComboBox<String> selectAlgorithmComboBox;

    @FXML
    private Button startButton, resetButton, stopButton;

    @FXML
    private Slider speedSlider;

    @FXML
    private Label statusLabel;

    private VisualizerCanvas visualizerCanvas;
    private Thread sortingThread;
    private SortingAlgorithm currentAlgorithm;

    /**
     * Initializes the controller, setting up the UI components, configuring event handlers,
     * and preparing the visualizer canvas. This method is automatically called after the FXML file
     * has been loaded.
     */
    @FXML
    public void initialize() {
        visualizerCanvas = new VisualizerCanvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        canvasContainer.getChildren().add(visualizerCanvas);

        speedSlider.valueProperty().bindBidirectional(visualizerCanvas.visualizationDelayProperty());
        speedSlider.setMin(1);
        speedSlider.setMax(100);
        speedSlider.setValue(DEFAULT_SPEED);

        startButton.setOnAction(event -> startSorting());
        resetButton.setOnAction(event -> resetSorting());
        stopButton.setOnAction(event -> stopSorting());

        selectAlgorithmComboBox.getItems().addAll(Arrays.stream(SortingAlgorithmType.values())
                .map(SortingAlgorithmType::getDisplayName)
                .toArray(String[]::new));

        selectAlgorithmComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            SortingAlgorithmType value = SortingAlgorithmType.getTypeFromString(newValue);
            visualizerCanvas.setSortingAlgorithm(value != null ? value : SortingAlgorithmType.BUBBLE_SORT);
            startButton.setDisable(false); // Re-enable the start button
            updateStatusLabel("Algorithm selected: " + newValue + ".", false);
        });

        selectAlgorithmComboBox.getSelectionModel().selectFirst();

        canvasContainer.widthProperty().addListener((obs, oldVal, newVal) -> {
            visualizerCanvas.setWidth(newVal.doubleValue());
            visualizerCanvas.update();
        });
        canvasContainer.heightProperty().addListener((obs, oldVal, newVal) -> {
            visualizerCanvas.setHeight(newVal.doubleValue());
            visualizerCanvas.update();
        });
    }

    /**
     * Starts the sorting process using the currently selected algorithm.
     * If a sorting process is already in progress, it displays an error message.
     */
    private void startSorting() {
        if (sortingThread != null && sortingThread.isAlive()) {
            updateStatusLabel("Sorting is already in progress.", true);
            return;
        }

        startButton.setDisable(true); // Disable the start button
        updateStatusLabel("Sorting started.", false);
        currentAlgorithm = visualizerCanvas.getSortingAlgorithm();
        sortingThread = new Thread(currentAlgorithm);
        sortingThread.setDaemon(true); // Ensures the thread doesn't prevent the application from exiting
        sortingThread.start();
    }

    /**
     * Resets the visualizer canvas to its initial state, ready for a new sorting operation.
     * It stops any ongoing sorting process before resetting the array.
     */
    private void resetSorting() {
        stopSorting();
        visualizerCanvas.resetArray();
        updateStatusLabel("Array reset.", false);
    }

    /**
     * Stops the currently running sorting process and updates the status label to indicate
     * that the sorting has been stopped.
     */
    private void stopSorting() {
        if (currentAlgorithm != null) {
            currentAlgorithm.stopRunning();
            updateStatusLabel("Sorting stopped.", false);
        }
        startButton.setDisable(false); // Re-enable the start button
    }

    /**
     * Updates the status label with a specified message. The message style is adjusted
     * based on whether it's an error message.
     *
     * @param text    The message to display in the status label.
     * @param isError True if the message is an error message, changing the text color to red; false otherwise.
     */
    private void updateStatusLabel(String text, boolean isError) {
        Platform.runLater(() -> {
            statusLabel.setText(text);
            statusLabel.setStyle(isError ? "-fx-text-fill: red;" : "-fx-text-fill: black;");
        });
    }
}
