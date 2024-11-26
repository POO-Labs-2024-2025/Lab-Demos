package org.example.design_patterns.observer;

/**
 * Implementation for our Observer, again we can define custom treatments by adding a new class
 * that inherits the StockObserver class.
 */
public class Investor implements StockObserver {
    private String name;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockSymbol, double stockPrice) {
        System.out.println(name + " received an update for " + stockSymbol + ": $" + stockPrice);
    }
}
