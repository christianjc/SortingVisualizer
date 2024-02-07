package com.sortingvisualizer.model;

import com.sortingvisualizer.view.VisualizerCanvas;

public class QuickSort implements SortingAlgorithm {

    private final VisualizerCanvas canvas;
    private volatile boolean running = true;

    public QuickSort(VisualizerCanvas canvas) {
        this.canvas = canvas;
    }
    public void stopRunning() {
        running = false;
    }
    @Override
    public void run(){

    }
    @Override
    public void sort() {
        int[] array = canvas.getArray();
        quickSort(array, 0, array.length - 1, canvas);
    }

    private void quickSort(int[] array, int low, int high, VisualizerCanvas canvas) {
        if (low < high) {
            int pi = partition(array, low, high, canvas);

            quickSort(array, low, pi - 1, canvas);
            quickSort(array, pi + 1, high, canvas);
        }
    }

    private int partition(int[] array, int low, int high, VisualizerCanvas canvas) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;

                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;

                // Update the visualization
                canvas.drawArray(array);
                pauseForVisualization();
            }
        }

        // Swap array[i+1] and array[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        // Update the visualization
        canvas.drawArray(array);
        pauseForVisualization();

        return i + 1;
    }

    private void pauseForVisualization() {
        try {
            Thread.sleep(20); // Delay for visualization purposes
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Properly handle thread interruption
        }
    }
}
