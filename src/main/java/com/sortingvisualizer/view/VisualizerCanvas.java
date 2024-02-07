package com.sortingvisualizer.view;

import com.sortingvisualizer.model.BubbleSort;
import com.sortingvisualizer.model.QuickSort;
import com.sortingvisualizer.model.SortingAlgorithm;
import com.sortingvisualizer.util.SortingAlgorithmType;
import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;
import java.util.function.Consumer;

public class VisualizerCanvas extends Canvas {
    private int[] array;
    private final GraphicsContext gc;

    private SortingAlgorithm algorithm;

    private int arraySize;

    public VisualizerCanvas(double width, double height) {
        super(width, height);
        gc = this.getGraphicsContext2D();
        arraySize = 100;
        setRandomArray(arraySize); // Initialize with 100 elements by default
        algorithm = new BubbleSort(this);
        drawArray(this.array);
    }

    public void setRandomArray(int size) {
        array = new int[size];
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt((int) (getHeight() - 10)) + 10; // Ensure bars fit within canvas height
        }
    }
    public void drawArray(int[] array) {
        Platform.runLater(() -> {
            gc.clearRect(0, 0, getWidth(), getHeight());
            double barWidth = getWidth() / array.length;
            for (int i = 0; i < array.length; i++) {
                gc.setFill(Color.BLUE);
                gc.fillRect(i * barWidth, getHeight() - array[i], barWidth - 1, array[i]);
            }
        });
    }


    public SortingAlgorithm getSortingAlgorithm() {
        return this.algorithm;
    }

    public void setSortingAlgorithm(SortingAlgorithmType algo) {
        switch (algo) {
            case BUBBLE_SORT -> this.algorithm = new BubbleSort(this);
            case QUICK_SORT -> this.algorithm = new QuickSort(this);
            default -> this.algorithm = new BubbleSort(this);
        }
    }

    public void setArray(int[] array) {
        this.array = array;
        drawArray(array);
    }

    public void changeArray(Consumer<int[]> modifier) {
        modifier.accept(this.array);
        drawArray(this.array);

    }

    public void resetArray() {
        setRandomArray(arraySize);
    }

    public int[] getArray() {
        return array;
    }

    public void setArraySize(int size) {
        this.arraySize = size;
    }

    public int getArraySize(){
        return this.arraySize;
    }
}
