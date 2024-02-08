package com.sortingvisualizer.view;

import com.sortingvisualizer.model.BubbleSort;
import com.sortingvisualizer.model.QuickSort;
import com.sortingvisualizer.model.SortingAlgorithm;
import com.sortingvisualizer.util.SortingAlgorithmType;
import javafx.application.Platform;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

/**
 * VisualizerCanvas is responsible for visualizing the sorting algorithms.
 * It extends Canvas and provides functionalities to draw and update the
 * array representation on the canvas.
 */
public class VisualizerCanvas extends Canvas {
    private int[] array;
    private final GraphicsContext gc;
    private SortingAlgorithm algorithm;
    private int arraySize;
    private final LongProperty visualizationDelay = new SimpleLongProperty(100);


    /**
     * Constructs a VisualizerCanvas with specified dimensions and initializes it with a default array and algorithm.
     *
     * @param width  the width of the canvas in pixels
     * @param height the height of the canvas in pixels
     */
    public VisualizerCanvas(double width, double height) {
        super(width, height);
        this.gc = this.getGraphicsContext2D();
        this.arraySize = 100; // Default array size
        initializeRandomArray(this.arraySize);
        this.algorithm = new BubbleSort(this); // Default algorithm
        drawArray();
    }


    /**
     * Initializes the array with random values and ensures the values are within the canvas height.
     *
     * @param size the number of elements in the array
     */
    public void initializeRandomArray(int size) {
        this.array = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            this.array[i] = rand.nextInt((int) (getHeight() - 10)) + 10; // Ensuring array values fit within the canvas height
        }
    }


    /**
     * Draws the array elements on the canvas. Each element's value determines its height on the canvas.
     * Elements to be highlighted are drawn in a different color.
     *
     * @param defaultColor       the color used to draw non-highlighted array elements
     * @param highlightedColor   the color used to draw highlighted array elements
     * @param highlightedIndices the indices of elements to highlight
     */
    private void drawArray(Color defaultColor, Color highlightedColor, int... highlightedIndices) {
        Platform.runLater(() -> {
            gc.clearRect(0, 0, getWidth(), getHeight());
            for (int i = 0; i < array.length; i++) {
                gc.setFill(contains(highlightedIndices, i) ? highlightedColor : defaultColor);
                gc.fillRect(i * getWidth() / array.length, getHeight() - array[i], getWidth() / array.length - 2, array[i]);
            }
        });
    }


    /**
     * Overloaded drawArray method to draw the array with a single highlighted color and specified highlighted elements.
     *
     * @param highlightedColor   the color used to draw highlighted array elements
     * @param highlightedIndices the indices of elements to highlight
     */
    private void drawArray(Color highlightedColor, int... highlightedIndices) {
        drawArray(Color.LIGHTGRAY, highlightedColor, highlightedIndices);
    }


    /**
     * Overloaded drawArray method with default colors.
     *
     * @param highlightedIndices indices of elements to highlight
     */
    private void drawArray(int... highlightedIndices) {
        drawArray(Color.BLACK, Color.RED, highlightedIndices);
    }


    /**
     * Helper method to check if an array contains a specific value, used for highlighting elements during sorting.
     *
     * @param arr the array to check
     * @param key the value to find
     * @return true if the value is found in the array, false otherwise
     */
    private static boolean contains(int[] arr, int key) {
        for (int value : arr) {
            if (value == key) {
                return true;
            }
        }
        return false;
    }


    /**
     * Swaps two elements in the array and updates the canvas to reflect the change.
     * The swapped elements are highlighted in the specified color.
     *
     * @param left  the index of the first element to swap
     * @param right the index of the second element to swap
     * @param color the color to use for highlighting the swapped elements
     */
    public void swap(int left, int right, Color color) {
        if (!isValidArrayIndex(left, right)) {
            throw new IllegalArgumentException("Swap indices out of bounds.");
        }
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
        drawArray(color, left, right);
        pauseForVisualization();
    }


    /**
     * Validates if the provided indices are within the bounds of the array.
     *
     * @param indices the indices to validate
     * @return true if all indices are within the bounds of the array, false otherwise
     */
    private boolean isValidArrayIndex(int... indices) {
        for (int index : indices) {
            if (index < 0 || index >= array.length) {
                return false;
            }
        }
        return true;
    }

    /**
     * Sets the sorting algorithm to be visualized.
     *
     * @param algo the SortingAlgorithmType indicating which algorithm to use
     */
    public void setSortingAlgorithm(SortingAlgorithmType algo) {
        switch (algo) {
            case BUBBLE_SORT -> algorithm = new BubbleSort(this);
            case QUICK_SORT -> algorithm = new QuickSort(this);
            default -> algorithm = new BubbleSort(this); // Fallback to BubbleSort by default
        }
    }


    private void pauseForVisualization() {
        try {

            Thread.sleep(getVisualizationDelay());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Handle thread interruption
        }
    }

    /**
     * Overloaded swap method with default highlight color.
     *
     * @param left  index of the first element
     * @param right index of the second element
     */
    public void swap(int left, int right) {
        swap(left, right, Color.RED);
    }


    /**
     * Returns the current sorting algorithm.
     *
     * @return the sorting algorithm in use
     */
    public SortingAlgorithm getSortingAlgorithm() {
        return algorithm;
    }


    /**
     * Returns the current array being visualized.
     *
     * @return the array being sorted
     */
    public int[] getArray() {
        return array;
    }


    /**
     * Sets a new array to be visualized.
     *
     * @param array the new array to set
     */
    public void setArray(int[] array) {
        this.array = array;
        drawArray();
    }

    /**
     * Returns the current size of the array being visualized.
     *
     * @return the size of the array
     */
    public int getArraySize() {
        return arraySize;
    }

    /**
     * Sets a new size for the array. This will reinitialize the array with random values of the new size.
     *
     * @param arraySize the new size of the array
     */
    public void setArraySize(int arraySize) {
        this.arraySize = arraySize;
        initializeRandomArray(arraySize);
    }

    /**
     * Gets the current visualization delay.
     *
     * @return the visualization delay in milliseconds
     */
    public long getVisualizationDelay() {
        return calculateDelayFromSlider(visualizationDelay.get());
    }

    /**
     * Sets the visualization delay. This delay affects the speed of the sorting visualization.
     *
     * @param visualizationDelay the new visualization delay in milliseconds
     */
    public void setVisualizationDelay(long visualizationDelay) {
        this.visualizationDelay.set(visualizationDelay);
    }


    /**
     * Returns the visualization delay property. This property allows binding to the visualization delay,
     * enabling reactive changes in the UI.
     *
     * @return the visualization delay property
     */
    public LongProperty visualizationDelayProperty() {
        return visualizationDelay;
    }

    public void resetArray() {
        initializeRandomArray(arraySize);
    }






    private long calculateDelayFromSlider(long value) {
//        System.out.println("Slider value = :" + value);
        long maxSliderValue = 100;
        long minSliderValue = 1;
        long maxDelay = 500; // Max delay (slowest speed) in milliseconds
        long minDelay = 5;   // Min delay (fastest speed) in milliseconds

        // Guard clauses for extreme values
        if (value <= minSliderValue) return maxDelay; // Slowest speed for min slider value
        if (value >= maxSliderValue) return minDelay; // Fastest speed for max slider value

        // Linear interpolation between minDelay and maxDelay based on the slider value
        long delayRange = maxDelay - minDelay;
        long sliderRange = maxSliderValue - minSliderValue;
        double scale = (double) delayRange / sliderRange;
        return (long) (maxDelay - scale * (value - minSliderValue));

    }


}

