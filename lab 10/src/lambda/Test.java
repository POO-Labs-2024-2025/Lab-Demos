package lambda;

interface Engine {
    int getFuelCapacity();
}

class Car {
    /**
     * Why even bother with so much code if we want to do something simple? Let's just use lambda for this.
     * @return fuelCapacity directly
     */
    public Engine getEngine() {
        return () -> 11;
    }
}

public class Test {
    public static void main(String[] args) {
        Car car = new Car();

        // Note we don't actually need a reference to Car anymore
        Engine firstEngine = car.getEngine();

        System.out.println(firstEngine.getFuelCapacity());
    }
}
