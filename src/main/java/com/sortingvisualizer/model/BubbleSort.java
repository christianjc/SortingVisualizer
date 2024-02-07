package com.sortingvisualizer.model;

import com.sortingvisualizer.view.VisualizerCanvas;

public class BubbleSort implements SortingAlgorithm {
    private final VisualizerCanvas canvas;

    public long getVisualizationDelay() {
        return visualizationDelay;
    }

    public void setVisualizationDelay(long visualizationDelay) {
        this.visualizationDelay = visualizationDelay;
    }

    private long visualizationDelay;
    public BubbleSort(VisualizerCanvas canvas) {
        this.canvas = canvas;
        this.visualizationDelay = 50;
    }

    private volatile boolean running = true;

    @Override
    public void stopRunning() {
        running = false;
    }
    @Override
    public void run(){
        sort();
        running = true;
    }

    @Override
    public void sort() {
        boolean swapped;
        int[] array = canvas.getArray();
        for (int i = 0; i < canvas.getArraySize() - 1; i++) {
            swapped = false;
            for (int j = 0; j < canvas.getArraySize() - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(j, j+1);
                    swapped = true;
                    pauseForVisualization();
                    if(shouldStopSorting()) return;
                }
            }
            if (!swapped) break;
        }
    }

    private void swap(int left, int right) {
        canvas.changeArray((arr)-> {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        });
    }

    private void pauseForVisualization() {
        try {
            Thread.sleep(visualizationDelay); // Delay for visualization purposes
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Properly handle thread interruption
        }
    }



    public boolean shouldStopSorting() {
        return Thread.currentThread().isInterrupted() || !running;
    }

}
