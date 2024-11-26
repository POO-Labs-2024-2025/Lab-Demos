package org.example.design_patterns.observer;

/**
 * Interface so we can define specialized Observables (maybe one does something special on notifyObserver)
 */
public interface StockMarket {
    void registerObserver(StockObserver observer);
    void removeObserver(StockObserver observer);
    void notifyObservers(String stockSymbol, double stockPrice);
}
