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
        import java.util.Objects;

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
            if (!Objects.equals(oldValue, newValue)) {
                System.out.println("Changing sorting type");
                SortingAlgorithmType value = SortingAlgorithmType.getTypeFromString(newValue);
                visualizerCanvas.setSortingAlgorithm(value != null ? value : SortingAlgorithmType.BUBBLE_SORT);
                updateStatusLabel("Algorithm selected " + newValue + ".", false);
            }
        });

        selectAlgorithmComboBox.getSelectionModel().selectFirst();
    }

    private void startSorting() {
        if (sortingThread != null && sortingThread.isAlive()) {
            updateStatusLabel("Sorting is already in progress.", true);
            return;
        }

        updateStatusLabel("Sorting started.", false);
        currentAlgorithm = visualizerCanvas.getSortingAlgorithm();
        sortingThread = new Thread(currentAlgorithm);
        sortingThread.setDaemon(true); // Ensure the thread doesn't prevent the application from exiting
        sortingThread.start();
    }

    private void resetSorting() {
        stopSorting();
        visualizerCanvas.resetArray();
        updateStatusLabel("Array reset.", false);
    }

    private void stopSorting() {
        if (currentAlgorithm != null) {
            currentAlgorithm.stopRunning();
            updateStatusLabel("Sorting stopped.", false);
        }
    }

    private void updateStatusLabel(String text, boolean isError) {
        Platform.runLater(() -> {
            statusLabel.setText(text);
            statusLabel.setStyle(isError ? "-fx-text-fill: red;" : "-fx-text-fill: black;");
        });
    }
}

