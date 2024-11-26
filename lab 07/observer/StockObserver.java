package org.example.design_patterns.observer;

public interface StockObserver {
    /**
     * Method that defines what happens when we receive an update
     */
    void update(String stockSymbol, double stockPrice);
}
