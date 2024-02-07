package com.sortingvisualizer.util;


public enum SortingAlgorithmType {
    BUBBLE_SORT("Bubble Sort"),
    QUICK_SORT("Quick Sort"),
    MERGE_SORT("Merge Sort");
    // Add more sorting algorithms as needed

    private final String displayName;

    SortingAlgorithmType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static SortingAlgorithmType getTypeFromString(String str){
        for (SortingAlgorithmType type : SortingAlgorithmType.values()) {
            if (type.getDisplayName().equalsIgnoreCase(str)) {
                return type;
            }
        }
        return null;
    }
}
