package org.example.design_patterns.observer;

public class ObserverTest {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarketImpl();

        StockObserver investor1 = new Investor("Alice");
        StockObserver investor2 = new Investor("Bob");

        stockMarket.registerObserver(investor1);
        stockMarket.registerObserver(investor2);

        stockMarket.notifyObservers("INFY", 1250.0); // Both investors receive updates
//        stockMarket.setStockPrice("TCS", 2500.0); // Both investors receive updates

        stockMarket.removeObserver(investor1);

//        stockMarket.setStockPrice("WIPRO", 700.0); // Only investor2 receives the update
    }
}
