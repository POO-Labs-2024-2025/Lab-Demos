package method_type;

public class Main {

    /**
     * We can now accept any type for our method even if the class does not specify a type.
     *
     * If we didn't add the <T> then the Java compiler would search for a class named T, which does not exist.
     *
     * @param type
     * @param <T>
     */
    static <T> void foo(T type) {
        System.out.println(type);
    }


    public static void main(String[] args) {
        String s = "luis";
        foo(s);
    }
}