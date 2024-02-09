package com.sortingvisualizer.util;

/**
 * The {@code SortingAlgorithmType} enum defines the types of sorting algorithms
 * available in the Sorting Visualizer application. Each enum constant represents
 * a distinct sorting algorithm and is associated with a human-readable display name.
 * <p>
 * This enum provides a centralized and type-safe way to manage and access the different
 * sorting algorithms supported by the application. It also includes a utility method
 * to retrieve an enum constant from its display name, facilitating user interaction
 * and dynamic algorithm selection.
 * </p>
 */
public enum SortingAlgorithmType {
    /**
     * Represents the Bubble Sort algorithm.
     */
    BUBBLE_SORT("Bubble Sort"),

    /**
     * Represents the Quick Sort algorithm.
     */
    QUICK_SORT("Quick Sort");

    // Here I can add more sorting algorithms as needed

    /**
     * The human-readable name of the sorting algorithm.
     */
    private final String displayName;

    /**
     * Constructs a new {@code SortingAlgorithmType} enum constant with the specified
     * display name.
     *
     * @param displayName The human-readable name for the sorting algorithm.
     */
    SortingAlgorithmType(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Returns the display name of the sorting algorithm.
     *
     * @return The human-readable name of the sorting algorithm.
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Retrieves a {@code SortingAlgorithmType} based on its display name. This method
     * performs a case-insensitive search among the defined enum constants and returns
     * the corresponding constant if a match is found.
     *
     * @param str The display name of the sorting algorithm to retrieve.
     * @return The {@code SortingAlgorithmType} constant corresponding to the specified
     *         display name, or {@code null} if no match is found.
     */
    public static SortingAlgorithmType getTypeFromString(String str) {
        for (SortingAlgorithmType type : SortingAlgorithmType.values()) {
            if (type.getDisplayName().equalsIgnoreCase(str)) {
                return type;
            }
        }
        return null;
    }
}
