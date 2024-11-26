package org.example.design_patterns.builder;

public class TestBuilder {
    public static void main(String[] args) {
        // Notice how simple it is to use and how we can define only the things we want.
        Pizza pizza = new Pizza.Builder("large", "thin")
                .cheeseCount(2)
                .pepperoniCount(1)
                .hamCount(1)
                .mushroomsCount(1)
                .build();
    }
}
