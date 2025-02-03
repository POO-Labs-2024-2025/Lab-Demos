package internal_class;

interface Engine {
    /**
     * We can use inherit doc btw.
     * @return
     */
    int getFuelCapacity();
}

class Car {
    private int fuelCapacity;
    private boolean isEconomy = false;

    /**
     * This works as well, it could also be static if you want.
     *
     * We could have used an anon class or this or a static class. Try to always use the one that results in less code
     */
    class OttoEngine implements Engine {

        /**
         * Let's do something hard, maybe we want to access a member of our external class.
         *
         * But this member is named the same as the parameter, well we cannot use `this.fuelCapacity` because this now
         * refers to OttoEngine.
         *
         * Solution: use ExternalClassName.this to access it.
         *
         * Note: if the names would not clash we can access it directly using its name (like we do for isEconomy). Also
         * it does not matter if the member is private, we are part of the class so we have access to it.
         * @param fuelCapacity
         */
        public OttoEngine(int fuelCapacity) {
            if (isEconomy) {
                Car.this.fuelCapacity = fuelCapacity;
            } else {
                Car.this.fuelCapacity = (int)(fuelCapacity * 1.5);
            }
        }

        /**
         * {@inheritDoc}
         * Here is our inherited doc.
         */
        public int getFuelCapacity() {
            return fuelCapacity;
        }
    }

    public OttoEngine getEngine() {
        return new OttoEngine(11);
    }
}



public class Test {
    public static void main(String[] args) {
        Car car = new Car();

        Car.OttoEngine firstEngine = car.getEngine();
        Car.OttoEngine secondEngine = car.new OttoEngine(10);

        System.out.println();


        System.out.println(firstEngine.getFuelCapacity());
        System.out.println(secondEngine.getFuelCapacity());
    }
}
