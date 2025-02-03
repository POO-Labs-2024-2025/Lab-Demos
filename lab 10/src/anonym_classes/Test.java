package anonym_classes;

interface Engine {
    int getFuelCapacity();
}

class Car {
    public Engine getEngine(int fuelCapacity) {
        // Effectively final -> it does not change
        // Notice that fuelCapacity is effectively final as well even if it is a parameter
        boolean isEconomy = true;

        // If we uncommented this, then it would not be effectively final so it won't work in our anon class
//        isEconomy = false;

        /*
         * An anonym class does not have a name because we return directly a child of an interface.
         *
         * Those can use only final or effectively final fields. Why? When we call this getter we get a new Engine.
         * To keep the external variables as well the Java Compiler copies the variables inside the class as well.
         * If the value is not final then isEconomy could change to false at whatever time and it would suck for us since
         * our value is hardcoded in our Anon class to be true, so there would be hidden bugs. That's why we want the value
         * to not change, to make sure the stuff we copy will be like that internally and externally forever.
         */
        return new Engine () {
//            private int fuelCapacity = 11;
            private String helloMessage = "Hello traveler";

            public int getFuelCapacity() {
                if (isEconomy) {
                    System.out.println(helloMessage + "wow this is economy");
                }

                return fuelCapacity;
            }
        };
    }
}

public class Test {
    public static void main(String[] args) {
        Car car = new Car();

        Engine firstEngine = car.getEngine(12);
        System.out.println(firstEngine);
    }
}
