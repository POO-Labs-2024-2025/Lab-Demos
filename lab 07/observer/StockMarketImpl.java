package org.example.design_patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of Observable
 */
public class StockMarketImpl implements StockMarket {
    // List to store the observers
    private final List<StockObserver> observers = new ArrayList<>();

    /**
     * Add observer
     */
    @Override
    public void registerObserver(StockObserver observer) {
        observers.add(observer);
    }

    /**
     * Remove observer
     */
    @Override
    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }

    /**
     * Call update to every observer
     */
    @Override
    public void notifyObservers(String stockSymbol, double stockPrice) {
        for (StockObserver observer : observers) {
            observer.update(stockSymbol, stockPrice);
        }
    }
}
