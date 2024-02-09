package com.sortingvisualizer.model;

/**
 * The {@code SortingAlgorithm} interface defines the structure for sorting algorithms
 * within the Sorting Visualizer application. It extends the {@link Runnable} interface,
 * allowing sorting algorithms to be executed in their own threads.
 * <p>
 * Implementing this interface requires defining the {@code sort()} method, which contains
 * the logic for the sorting algorithm, and the {@code stopRunning()} method, which provides
 * a mechanism to stop the execution of the sorting algorithm, typically used for interrupting
 * the algorithm before completion.
 * </p>
 */
public interface SortingAlgorithm extends Runnable {

    /**
     * Executes the sorting algorithm. This method should contain the core logic
     * for the sorting algorithm being implemented. It will be called when the sorting
     * process is started.
     */
    void sort();

    /**
     * Requests the sorting algorithm to stop execution. Implementations should ensure
     * this method causes the {@code sort()} method to return or complete as soon as possible.
     * <p>
     * This method provides a mechanism to safely and cleanly interrupt the sorting process,
     * allowing for the resources and threads used by the sorting algorithm to be released
     * or reused.
     * </p>
     */
    void stopRunning();
}
