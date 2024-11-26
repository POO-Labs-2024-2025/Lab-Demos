package org.example.design_patterns.builder;

/**
 * Why do we use Builder? Did you ever want optional constructor parameters? You have this solutions:
 * - create lots of constructors (one that contains the optional parameter, one that doesn't) -> too much code
 * - use getter/setters -> users that use our API can use the object we create uninitialized if they forget to
 * add the setters before using the instance (which is very likely)
 * - use Builder (BEST CHOICE)
 */
public class Pizza {
    private String pizzaSize;
    private String crust;
    private int cheeseCount;
    private int pepperoniCount;
    private int hamCount;
    private int mushroomsCount;

    // Internal class, must be static and public
    public static class Builder {
        // We have the same parameters as the external class
        private final String pizzaSize; // mandatory
        private final String crust; // mandatory
        private int cheeseCount = 0; // optional
        private int pepperoniCount = 0; // optional
        private int hamCount = 0; // optional
        private int mushroomsCount = 0; // optional

        /**
         * Constructor that contains the mandatory parameters
         */
        public Builder(String pizzaSize, String crust) {
            this.pizzaSize = pizzaSize;
            this.crust = crust;
        }

        /**
         * Specialized methods that return the current Builder instance after changing it
         */
        public Builder cheeseCount(int cheeseCount) {
            // We set the internal class' parameter
            this.cheeseCount = cheeseCount;

            // We return "this" that is a Builder that contains "cheeseCount" after it has been changed
            return this;
        }

        public Builder pepperoniCount(int pepperoniCount) {
            this.pepperoniCount = pepperoniCount;
            return this;
        }

        public Builder hamCount(int hamCount) {
            this.hamCount = hamCount;
            return this;
        }

        public Builder mushroomsCount(int mushroomsCount) {
            this.mushroomsCount = mushroomsCount;
            return this;
        }

        /**
         * Create the pizza after everything has been set
         */
        public Pizza build() {
            // Notice how we pass to Pizza the current instance of Builder that has everything altered as we want.
            return new Pizza(this);
        }
    }

    /**
     * PRIVATE CONSTRUCTOR SO WE WON'T EXPOSE THIS TO THE USER
     *
     * We need a Builder instance to simply copy the params.
     */
    private Pizza(Builder builder) {
        this.pizzaSize = builder.pizzaSize;
        this.crust = builder.crust;
        this.cheeseCount = builder.cheeseCount;
        this.pepperoniCount = builder.pepperoniCount;
        this.hamCount = builder.hamCount;
        this.mushroomsCount = builder.mushroomsCount;
    }

    // getters
}
