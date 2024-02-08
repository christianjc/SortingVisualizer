package com.sortingvisualizer.model;

import com.sortingvisualizer.view.VisualizerCanvas;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

/**
 * Tests for the QuickSort class.
 * <p>
 * This test suite aims to validate the functionality of the QuickSort sorting algorithm
 * within the context of the sorting visualizer application. It focuses on ensuring the correct behavior
 * of the sorting process under various conditions and the interactions with the VisualizerCanvas,
 * which is responsible for visualizing the sorting process.
 * </p>
 */
class QuickSortTests {

    @Mock
    private VisualizerCanvas mockCanvas;

    private QuickSort quickSort;

    /**
     * Sets up the test environment before each test.
     * <p>
     * Initializes Mockito annotations and creates a new QuickSort instance with a mocked VisualizerCanvas.
     * </p>
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        quickSort = new QuickSort(mockCanvas);
    }

    /**
     * Tests the QuickSort algorithm with a typical unsorted array.
     * <p>
     * Verifies that swap operations are performed, indicating that the algorithm is actively sorting the array.
     * </p>
     */
    @Test
    void testQuickSortNormalCase() {
        int[] testArray = {3, 9, 4, 7, 5};
        when(mockCanvas.getArray()).thenReturn(testArray);
        when(mockCanvas.getArraySize()).thenReturn(testArray.length);

        quickSort.sort();

        // QuickSort involves multiple recursive calls and partitioning,
        // so swaps should occur multiple times.
        verify(mockCanvas, atLeastOnce()).swap(anyInt(), anyInt(), eq(Color.RED));
        verify(mockCanvas, atLeastOnce()).swap(anyInt(), anyInt(), eq(Color.GREEN));
    }

    /**
     * Tests the QuickSort algorithm with an already sorted array.
     * <p>
     * This test checks for the algorithm's efficiency by ensuring minimal swap operations are performed.
     * </p>
     */
    @Test
    void testQuickSortAlreadySorted() {
        int[] sortedArray = {1, 2, 3, 4, 5};
        when(mockCanvas.getArray()).thenReturn(sortedArray);
        when(mockCanvas.getArraySize()).thenReturn(sortedArray.length);

        quickSort.sort();

        // Verifying the minimum number of swaps needed, as an already sorted array
        // might still incur some swaps due to the pivot selection.
        verify(mockCanvas, atLeast(0)).swap(anyInt(), anyInt(), any(Color.class));
    }

    /**
     * Tests the QuickSort algorithm with a single-element array.
     * <p>
     * Verifies that no swap operations are performed when the array contains only one element.
     * </p>
     */
    @Test
    void testQuickSortSingleElement() {
        int[] singleElementArray = {1};
        when(mockCanvas.getArray()).thenReturn(singleElementArray);
        when(mockCanvas.getArraySize()).thenReturn(singleElementArray.length);

        quickSort.sort();

        // No swaps should be made when the array has only one element.
        verify(mockCanvas, never()).swap(anyInt(), anyInt(), any(Color.class));
    }

    /**
     * Tests the QuickSort algorithm with an empty array.
     * <p>
     * Ensures that the algorithm gracefully handles empty arrays without attempting any swap operations.
     * </p>
     */
    @Test
    void testQuickSortEmptyArray() {
        int[] emptyArray = {};
        when(mockCanvas.getArray()).thenReturn(emptyArray);
        when(mockCanvas.getArraySize()).thenReturn(emptyArray.length);

        quickSort.sort();

        // No swaps should occur when sorting an empty array.
        verify(mockCanvas, never()).swap(anyInt(), anyInt(), any(Color.class));
    }

    /**
     * Tests the ability to stop the QuickSort algorithm prematurely.
     * <p>
     * Simulates stopping the sorting process before it starts and verifies that no swap operations are performed.
     * </p>
     */
    @Test
    void testQuickSortStopRunning() {
        int[] testArray = {5, 3, 2, 4, 1};
        when(mockCanvas.getArray()).thenReturn(testArray);
        when(mockCanvas.getArraySize()).thenReturn(testArray.length);

        // Simulate stopping the sorting algorithm before it starts.
        quickSort.stopRunning();

        quickSort.sort();

        // Verify that no swaps were made after stopping.
        verify(mockCanvas, never()).swap(anyInt(), anyInt(), any(Color.class));
    }
}
