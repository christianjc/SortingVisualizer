package com.sortingvisualizer.model;

import com.sortingvisualizer.view.VisualizerCanvas;
import javafx.scene.paint.Color;

/**
 * Implements the Bubble Sort algorithm and provides visualization support.
 */
public class BubbleSort implements SortingAlgorithm {
    private final VisualizerCanvas canvas; // Canvas for visualization
    private volatile boolean running = true; // Flag to control the execution

    /**
     * Constructs a BubbleSort instance with a specified canvas for visualization.
     *
     * @param canvas The canvas used to visualize the sorting process.
     */
    public BubbleSort(VisualizerCanvas canvas) {
        this.canvas = canvas;
    }

    /**
     * The main sorting method to be executed by the thread. It performs Bubble Sort
     * and visualizes the process on the canvas.
     */
    @Override
    public void run() {
        resetRunning();
        sort();
    }

    /**
     * Performs the Bubble Sort algorithm on the array provided by the canvas.
     */
    public void sort() {
        int[] array = canvas.getArray();
        for (int i = 0; i < canvas.getArraySize() - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < canvas.getArraySize() - 1; j++) {
                if (array[j] > array[j + 1]) {
                    canvas.swap(j, j+1, Color.RED);
                    swapped = true;
//                    pauseForVisualization();
                    if (shouldStopSorting()) {
                        return; // Early exit if sorting should be stopped
                    }
                }
            }
            if(!swapped) break;
        }
    }

    /**
     * Requests the sorting process to stop by setting the running flag to false.
     */
    public void stopRunning() {
        running = false;
    }

    /**
     * Restarts the running flag to true so that the sorting process can proceed.
     */
    public void resetRunning(){
        running = true;
    }


    /**
     * Checks if the current thread is interrupted or if the running flag is set to false.
     *
     * @return true if the thread is interrupted or the running flag is false, indicating the sorting should stop.
     */
    private boolean shouldStopSorting() {
        return Thread.currentThread().isInterrupted() || !running;
    }
}
