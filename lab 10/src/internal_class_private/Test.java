package internal_class_private;

interface Engine {
    int getFuelCapacity();
}

class Car {
    /**
     * Just like you guessed, we cannot access this from outside the external class.
     */
    private class OttoEngine implements Engine {
        private int fuelCapacity;

        public OttoEngine(int fuelCapacity) {
            this.fuelCapacity = fuelCapacity;
        }

        public int getFuelCapacity() {
            return fuelCapacity;
        }
    }

    /**
     * So we need a getter to get data about it.
     *
     * @return new instance of the internal class
     */
    public Engine getEngine() {
        return new OttoEngine(11);
    }
}

public class Test {
    public static void main(String[] args) {
        Car car = new Car();

        Engine firstEngine = car.getEngine();

        // This we cannot do because the internal class is private
//        Car.OttoEngine secondEngine = car.new OttoEngine(10);

        System.out.println(firstEngine.getFuelCapacity());
//        System.out.println(secondEngine.getFuelCapacity());
    }
}
