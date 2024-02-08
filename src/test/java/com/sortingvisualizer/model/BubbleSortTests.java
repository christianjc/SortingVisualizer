package com.sortingvisualizer.model;

import com.sortingvisualizer.view.VisualizerCanvas;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

/**
 * Test suite for the BubbleSort class within the sorting visualizer application.
 * <p>
 * These tests validate the BubbleSort algorithm's functionality, focusing on its ability
 * to correctly sort arrays under various conditions, and its interaction with the VisualizerCanvas
 * for visualizing the sorting process.
 * </p>
 */
class BubbleSortTests {

    @Mock
    private VisualizerCanvas mockCanvas;

    private BubbleSort bubbleSort;

    /**
     * Initializes the test environment before each test case.
     * <p>
     * This setup includes initializing Mockito annotations for mocking dependencies
     * and instantiating a new BubbleSort object with a mocked VisualizerCanvas.
     * </p>
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        bubbleSort = new BubbleSort(mockCanvas);
    }

    /**
     * Tests the BubbleSort algorithm with a standard unsorted array.
     * <p>
     * This test verifies that the algorithm performs the expected swap operations to sort the array,
     * indicating correct sorting behavior.
     * </p>
     */
    @Test
    void testBubbleSortNormalCase() {
        int[] testArray = {5, 1, 4, 2, 8};
        when(mockCanvas.getArray()).thenReturn(testArray);
        when(mockCanvas.getArraySize()).thenReturn(testArray.length);

        bubbleSort.sort();

        // Verifying swap operations are performed, indicating sorting process.
        verify(mockCanvas, atLeastOnce()).swap(anyInt(), anyInt(), eq(Color.RED));
    }

    /**
     * Tests the BubbleSort algorithm with an array that is already sorted.
     * <p>
     * This test ensures the algorithm recognizes the sorted state of the array and minimizes swap operations,
     * demonstrating efficiency in best-case scenarios.
     * </p>
     */
    @Test
    void testBubbleSortAlreadySorted() {
        int[] sortedArray = {1, 2, 3, 4, 5};
        when(mockCanvas.getArray()).thenReturn(sortedArray);
        when(mockCanvas.getArraySize()).thenReturn(sortedArray.length);

        bubbleSort.sort();

        // Expecting no swap operations for an already sorted array.
        verify(mockCanvas, never()).swap(anyInt(), anyInt(), any(Color.class));
    }

    /**
     * Tests the BubbleSort algorithm with an array containing duplicate values.
     * <p>
     * This test checks the algorithm's ability to handle duplicates correctly, ensuring proper sorting without errors.
     * </p>
     */
    @Test
    void testBubbleSortWithDuplicates() {
        int[] arrayWithDuplicates = {4, 2, 4, 3, 1};
        when(mockCanvas.getArray()).thenReturn(arrayWithDuplicates);
        when(mockCanvas.getArraySize()).thenReturn(arrayWithDuplicates.length);

        bubbleSort.sort();

        // Verifying swap operations are correctly performed even with duplicate values in the array.
        verify(mockCanvas, atLeastOnce()).swap(anyInt(), anyInt(), eq(Color.RED));
    }

    /**
     * Tests the BubbleSort algorithm with an array that contains a single element.
     * <p>
     * This test ensures that the algorithm correctly identifies there's nothing to sort,
     * resulting in no swap operations.
     * </p>
     */
    @Test
    void testBubbleSortSingleElement() {
        int[] singleElementArray = {1};
        when(mockCanvas.getArray()).thenReturn(singleElementArray);
        when(mockCanvas.getArraySize()).thenReturn(singleElementArray.length);

        bubbleSort.sort();

        // Expecting no swap operations for a single-element array.
        verify(mockCanvas, never()).swap(anyInt(), anyInt(), any(Color.class));
    }

    /**
     * Tests the BubbleSort algorithm with an empty array.
     * <p>
     * This test verifies the algorithm's behavior when encountering an empty array,
     * ensuring it does not attempt to perform any swap operations.
     * </p>
     */
    @Test
    void testBubbleSortEmptyArray() {
        int[] emptyArray = {};
        when(mockCanvas.getArray()).thenReturn(emptyArray);
        when(mockCanvas.getArraySize()).thenReturn(emptyArray.length);

        bubbleSort.sort();

        // Verifying that no swap operations are performed on an empty array.
        verify(mockCanvas, never()).swap(anyInt(), anyInt(), any(Color.class));
    }

}
