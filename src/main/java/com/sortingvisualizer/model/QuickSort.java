package com.sortingvisualizer.model;

import com.sortingvisualizer.view.VisualizerCanvas;
import javafx.scene.paint.Color;

public class QuickSort implements SortingAlgorithm {

    private final VisualizerCanvas canvas;
    private volatile boolean running = true;

    public QuickSort(VisualizerCanvas canvas) {
        this.canvas = canvas;
    }
    public void stopRunning() {
        running = false;

    }

    /**
     * Restarts the running flag to true so that the sorting process can proceed.
     */
    public void resetRunning(){
        running = true;
    }
    @Override
    public void run(){
        resetRunning();
        sort();
    }
    @Override
    public void sort() {
        int[] array = canvas.getArray();
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int low, int high) {
        if (shouldStopSorting()) {
            return; // Early exit if sorting should be stopped
        }
        if (low < high) {
            int pi = partition(array, low, high, canvas);

            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private int partition(int[] array, int low, int high, VisualizerCanvas canvas) {
        if (shouldStopSorting()) {
            return 0; // Early exit if sorting should be stopped
        }
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;

                // Swap array[i] and array[j]
                canvas.swap(i, j, Color.RED);

            }
        }

        // Swap array[i+1] and array[high] (or pivot)
        canvas.swap(i + 1, high, Color.GREEN);

        return i + 1;
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
