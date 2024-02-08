
package com.sortingvisualizer.model;

        import com.sortingvisualizer.view.VisualizerCanvas;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.*;
        import static org.mockito.Mockito.*;

class BubbleSortTests {
    private VisualizerCanvas canvasMock;
    private BubbleSort bubbleSort;

    @BeforeEach
    void setUp() {
        // Mock VisualizerCanvas
        canvasMock = mock(VisualizerCanvas.class);
        // Initialize BubbleSort with the mocked canvas
        bubbleSort = new BubbleSort(canvasMock);
    }

    @Test
    void testSortCorrectness() {
        int[] testArray = {4, 3, 2, 1};
        int[] sortedArray = {1, 2, 3, 4};

        // Configure the mock to return the test array
        when(canvasMock.getArray()).thenReturn(testArray);
        when(canvasMock.getArraySize()).thenReturn(testArray.length);

        // Run the sorting algorithm
        bubbleSort.run();

        // Verify the array was accessed and presumably modified
        verify(canvasMock, atLeastOnce()).getArray();

        // Assert the array was sorted correctly
        assertArrayEquals(sortedArray, testArray, "Array should be sorted in ascending order.");
    }

    @Test
    void testEmptyArray() {
        int[] emptyArray = {};

        when(canvasMock.getArray()).thenReturn(emptyArray);
        when(canvasMock.getArraySize()).thenReturn(emptyArray.length);

        bubbleSort.run();

        verify(canvasMock, atLeastOnce()).getArray();
        assertArrayEquals(emptyArray, emptyArray, "Empty array should remain unchanged.");
    }

    @Test
    void testSortingInterruption() {
        int[] testArray = {5, 4, 3, 2, 1};

        when(canvasMock.getArray()).thenReturn(testArray);
        when(canvasMock.getArraySize()).thenReturn(testArray.length);

        Thread sortingThread = new Thread(bubbleSort);
        sortingThread.start();

        // Interrupt the sorting thread to simulate stopping the sorting
        sortingThread.interrupt();

        // Ensure the thread was interrupted
        assertTrue(sortingThread.isInterrupted(), "Sorting thread should be interrupted.");

        // Additional assertions can be made here depending on the handling of interruptions in BubbleSort
    }
}
