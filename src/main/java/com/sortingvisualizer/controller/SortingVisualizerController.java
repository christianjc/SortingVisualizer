package com.sortingvisualizer.controller;

import com.sortingvisualizer.model.SortingAlgorithm;
import com.sortingvisualizer.util.SortingAlgorithmType;
import com.sortingvisualizer.view.VisualizerCanvas;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;

import java.util.Objects;

public class SortingVisualizerController {

    @FXML
    private Pane canvasContainer;

    @FXML
    private ComboBox<String> selectAlgorithmComboBox;

    @FXML
    private Button startButton, resetButton, stopButton;

    private VisualizerCanvas visualizerCanvas;

    private Thread sortingThread;

    private SortingAlgorithm algorithm;

    @FXML
    public void initialize() {
        visualizerCanvas = new VisualizerCanvas(800, 550);
        canvasContainer.getChildren().add(visualizerCanvas);
//        algorithmController = new BubbleSort();
        startButton.setOnAction(event -> startSorting());
        resetButton.setOnAction(event -> visualizerCanvas.setRandomArray(visualizerCanvas.getArray().length));
        stopButton.setOnAction(event -> stopSorting());


        selectAlgorithmComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)-> {
            if (!Objects.equals(oldValue, newValue)) {
                System.out.println("Changing sorting type");
                SortingAlgorithmType value = SortingAlgorithmType.getTypeFromString(newValue);
                if (value == null) value = SortingAlgorithmType.BUBBLE_SORT;
                visualizerCanvas.setSortingAlgorithm(value);
            }
        });
        selectAlgorithmComboBox.getItems().addAll(SortingAlgorithmType.BUBBLE_SORT.getDisplayName(), SortingAlgorithmType.QUICK_SORT.getDisplayName(), SortingAlgorithmType.MERGE_SORT.getDisplayName()); // Add as many sorting algorithms as you have implemented
        selectAlgorithmComboBox.getSelectionModel().selectFirst(); // Optional: select the first algorithm by default

    }

    private void startSorting() {
        if (sortingThread == null || !sortingThread.isAlive()) {
            System.out.println("Creating new Tread");
            algorithm = visualizerCanvas.getSortingAlgorithm();
            sortingThread = new Thread(algorithm);
            sortingThread.start();
        }
    }

    private void resetArray() {
        visualizerCanvas.setRandomArray(visualizerCanvas.getArray().length); // Reinitialize the array with the same size
    }

    private void stopSorting() {
//        visualizerCanvas.getSortingAlgorithm().stopRunning();
        algorithm.stopRunning();
//        if (sortingThread != null && sortingThread.isAlive()) {
//            sortingThread.interrupt();
//        }
    }

//    @FXML
//    private void handleStartSort() {
//        String selectedAlgorithm = selectAlgorithm.getValue();
//
//
//
//        visualizerCanvas.startSorting();
//    }



}