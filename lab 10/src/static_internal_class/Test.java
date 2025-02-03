package static_internal_class;

interface Engine {
    int getFuelCapacity();
}

class Car {
    private static boolean isEconomy = true;
    private String message = "Not static";

    /**
     * Static classes only have access to static contexts.
     */
    static class OttoEngine implements Engine {
        private int fuelCapacity;

        public OttoEngine(int fuelCapacity) {
            // We have access to isEconomy even if it is outside our class since it is static
            if (isEconomy) {
                this.fuelCapacity = fuelCapacity;
            }

            // We don't have access to this though since it's not static
//            System.out.println(message);
        }

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

        // Note we can do this
        Car.OttoEngine firstEngine = car.getEngine();

        /* But we can also do this which means we actualy don't need to create an external class
        * So if we have an internal class that does not need an internal class, why even make it internal?
        * Two reasons:
        * - the best reason is the one above to access static members
        * - the meh reason is to better group classes but you could do that already with packages
         */
        Car.OttoEngine secondEngine = new Car.OttoEngine(12);

        System.out.println(firstEngine.getFuelCapacity());
        System.out.println(secondEngine.getFuelCapacity());
    }
}
