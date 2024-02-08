package com.sortingvisualizer.model;

        import com.sortingvisualizer.view.VisualizerCanvas;


        import javafx.scene.paint.Color;


public class QuickSort implements SortingAlgorithm {

    private final VisualizerCanvas canvas;
    private volatile boolean running = true;

    public QuickSort(VisualizerCanvas canvas) {
        this.canvas = canvas;
    }

    /**
     * Stops the sorting algorithm by setting the running flag to false.
     */
    public void stopRunning() {
        running = false;
    }

    /**
     * Resets the running flag to true to allow the sorting process to proceed.
     */
    public void resetRunning() {
        running = true;
    }

    /**
     * The main sorting method to be executed by the thread.
     * It initializes the sorting process and ensures the running flag is reset.
     */
    @Override
    public void run() {
        resetRunning();
        sort();
    }

    /**
     * Initiates the QuickSort algorithm on the array.
     */
    @Override
    public void sort() {
        int[] array = canvas.getArray();
        quickSort(array, 0, array.length - 1);
    }

    /**
     * Performs the QuickSort algorithm recursively.
     *
     * @param array The array to be sorted.
     * @param low   The starting index.
     * @param high  The ending index.
     */
    private void quickSort(int[] array, int low, int high) {
        if (shouldStopSorting()) {
            return; // Early exit if sorting should be stopped
        }

        if (low < high) {
            int pi = partition(array, low, high);

            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    /**
     * Partitions the array around a pivot and performs necessary swaps.
     *
     * @param array The array to be partitioned.
     * @param low   The starting index.
     * @param high  The ending index.
     * @return The partitioning index.
     */
    private int partition(int[] array, int low, int high) {
        if (shouldStopSorting()) {
            return 0; // Early exit if sorting should be stopped
        }

        int pivot = array[high];
        int i = (low - 1); // Index of smaller element

        for (int j = low; j < high; j++) {
            if (shouldStopSorting()) {
                return 0; // Early exit if sorting should be stopped
            }
            // If the current element is smaller than or equal to pivot
            if (array[j] < pivot) {
                i++;
                canvas.swap(i, j, Color.RED); // Swap array[i] and array[j]
            }
        }

        canvas.swap(i + 1, high, Color.GREEN); // Swap array[i+1] and array[high] (or pivot)
        return i + 1;
    }

    /**
     * Checks if the sorting process should be stopped, either due to an interruption or a stop request.
     *
     * @return true if the sorting process should be halted, false otherwise.
     */
    private boolean shouldStopSorting() {
        return Thread.currentThread().isInterrupted() || !running;
    }
}
