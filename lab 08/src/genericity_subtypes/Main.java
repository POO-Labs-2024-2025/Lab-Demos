package genericity_subtypes;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();

        // Why does the compiler show an error here? After all, all objects inherit the Object class.
//        List<Object> objectList = stringList;

        // If we add a new object here
//        objectList.add(new Object());/

        // This won't be a String, so the compiler won't allow parent types
//        String s = stringList.get(0);

        // This does not work as well because a reference of type List Object is not the same as the type of List String
//        List<Object> objectList = new ArrayList<>();
//        List<String> anotherStringList = objectList;

    }
}
