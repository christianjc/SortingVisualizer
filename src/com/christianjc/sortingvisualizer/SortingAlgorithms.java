package com.christianjc.sortingvisualizer;

import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class SortingAlgorithms {

    private int[] array;
    private GraphicsContext gc;
    private int canvasWidth;
    private int canvasHeight;
    private volatile boolean running = true;

    public SortingAlgorithms(GraphicsContext gc, int[] array, int canvasWidth, int canvasHeight) {
        this.gc = gc;
        this.array = array;
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
    }

    public void bubbleSort() {
        for (int n = array.length; n > 1 && running; n--) {
            for (int i = 0; i < n - 1 && running; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    final int j = i; // For use in lambda
                    Platform.runLater(() -> drawBars(j, j + 1));
                    sleep(100); // Slow down for visualization
                }
            }
        }
        running = true; // Reset for next sort
    }

    private void drawBars(int... highlightedIndices) {
        gc.clearRect(0, 0, canvasWidth, canvasHeight); // Clear the canvas
        for (int i = 0; i < array.length; i++) {
            if (contains(highlightedIndices, i)) {
                gc.setFill(Color.RED); // Highlight the current bars being swapped
            } else {
                gc.setFill(Color.BLACK); // Default bar color
            }
            gc.fillRect(i * (double) canvasWidth / array.length, canvasHeight - array[i], canvasWidth / array.length - 2, array[i]);
        }
    }

    private boolean contains(int[] arr, int key) {
        for (int value : arr) {
            if (value == key) {
                return true;
            }
        }
        return false;
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void stop() {
        running = false;
    }
}
