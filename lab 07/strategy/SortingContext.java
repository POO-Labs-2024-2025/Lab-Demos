package org.example.design_patterns.strategy;

import org.example.design_patterns.strategy.strategies.SortingStrategy;

public class SortingContext {
    private SortingStrategy sortingStrategy;

    /**
     * Either in the constructor or the setter below we simply pass the strategy we want.
     *
     * It's that simple.
     *
     * After this when we call sort the method is chosen at RUNTIME due to the fact that inheritance
     * is dynamic which allows custom strategies based on conditions!!!
     */
    public SortingContext(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void performSort(int[] array) {
        sortingStrategy.sort(array);
    }
}
