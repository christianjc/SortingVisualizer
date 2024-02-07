package com.christianjc.sortingvisualizer;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Random;

public class SortingVisualizerApp extends Application {

    private Canvas canvas;
    private SortingAlgorithms sortingAlgorithms;
    private int[] array;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sorting Algorithm Visualizer");

        VBox root = new VBox(10);
        canvas = new Canvas(800, 600);
        Pane canvasHolder = new Pane(canvas);
        HBox controls = new HBox(10);
        controls.setAlignment(Pos.CENTER);

        ToggleGroup sizeGroup = new ToggleGroup();
        for (int size : new int[]{50, 100, 150, 200, 250}) {
            ToggleButton toggle = new ToggleButton(String.valueOf(size));
            toggle.setUserData(size);
            toggle.setToggleGroup(sizeGroup);
            controls.getChildren().add(toggle);
        }

        sizeGroup.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            if (newToggle != null) {
                int newSize = (int) newToggle.getUserData();
                array = generateRandomArray(newSize, 10, 590);
                drawArray();
            }
        });

        Button startSort = new Button("Start Sort");
        startSort.setOnAction(event -> new Thread(() -> sortingAlgorithms.bubbleSort()).start());

        Button reset = new Button("Reset");
        reset.setOnAction(event -> {
            array = shuffleArray(array);
            drawArray();
        });

        Button stop = new Button("Stop");
        stop.setOnAction(event -> sortingAlgorithms.stop());

        controls.getChildren().addAll(startSort, reset, stop);
        root.getChildren().addAll(canvasHolder, controls);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

        array = generateRandomArray(100, 10, 590);
        sortingAlgorithms = new SortingAlgorithms(canvas.getGraphicsContext2D(), array, (int) canvas.getWidth(), (int) canvas.getHeight());
        drawArray();
    }

    private void drawArray() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (int i = 0; i < array.length; i++) {
            gc.fillRect(i * (double) canvas.getWidth() / array.length, canvas.getHeight() - array[i], canvas.getWidth() / array.length - 2, array[i]);
        }
    }

    private int[] generateRandomArray(int size, int min, int max) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt((max - min) + 1) + min;
        }
        return arr;
    }

    private int[] shuffleArray(int[] array) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            int randomIndex = rand.nextInt(array.length);
            int temp = array[randomIndex];
            array[randomIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
