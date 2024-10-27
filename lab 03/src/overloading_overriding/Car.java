package overloading_overriding;

public class Car {
    public void print() {
        System.out.println("Car");
    }

    public void init() {
        System.out.println("Car");
    }

    public void addGasoline() {
        // do something
    }
}

class Dacia extends Car {
    public void print() {
        System.out.println("Dacia");
    }

    public void init() {
        System.out.println("Dacia");
    }

    // Overriding (please add the decorator @Override)
    public void addGasoline() {
        // do something
    }

    // Overloading
    public void addGasoline(Integer gallons) {
        // do something
    }

    // Is this overloading? No, because if I call in my main method addGasoline() how will the compiler or JVM know
    // what method am I referring to? How will it know if I want to get as a return value void or String? It can't know,
    // so this is NOT overloading, hence the reason that a method's SIGNATURE does not contain the return type.
    public String addGasoline() {
        return "gas";
    }

    public void startEngineWithScrewdriver() {
        // do something
    }

    public static void main(String[] args) {
        // the right member is the instance (Dacia, available at runtime), the left member is the
        // reference (Car, available at compile time)
        Car car = new Dacia();

        // This will call the method from the instance (from the Dacia class). This happens only at runtime since it has to
        // check the specific instance which is available only at runtime (when the memory is allocated).
        car.addGasoline();

        // Going forward with the reference and instance examples, this code below will not compile since the reference
        // is of type 'Car' and Car does not have this method. The instance has this method, but how can the compiler know
        // that you won't change the instance to another class that does not have this method? Thus, an error is thrown.
        car.startEngineWithScrewdriver();

        // But this work since the reference is now of type 'Dacia'
        Dacia carDacia = new Dacia();
        carDacia.startEngineWithScrewdriver();

        // It's important to note that overloading looks at the reference, so it's a compile time mechanism, therefore
        // the example above applies below, since the overloaded method is not available to the reference.
        car.addGasoline(1);

        // But this works.
        carDacia.addGasoline(1);
    }
}

