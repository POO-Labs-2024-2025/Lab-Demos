package org.example.design_patterns.strategy.strategies;

public interface SortingStrategy {
    // Method that has multiple strategies (implemented by inheriting this class)
    void sort(int[] array);
}
