package records;

import java.util.Objects;

/**
 * The constructor is autogenerated where we have to pass both arguments.
 *
 * @param name
 * @param address
 */
public record Student(String name, String address) {
    public static String UNKNOWN_ADDRESS = "Unknown"; // You can have static variables

    // We can define custom constructors where we call our default Record constructor
    public Student(String name) {
        this(name, UNKNOWN_ADDRESS);
    }

    // You can have static methods
    public static Student unnamed(String address) {
        return new Student("Unnamed", address);
    }

    // You can have getters in a Record
    @Override
    public String name() {
        return name;
    }

    @Override
    public String address() {
        return address;
    }

    // You can also have equals, hashCode and toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(address, student.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
