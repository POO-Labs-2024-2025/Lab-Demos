package wildcards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    /**
     * This method accepts only Object. Why? Well subtypes do not work as discussed and there are no other parents to
     * Object so we are stuck with Objects only.
     * @param c
     */
    void printCollection(Collection<Object> c) {
        for (Object e : c)
            System.out.println(e);
    }

    /**
     * How do we solve that? With wildcards. Now we can pass Collections of any types.
     *
     * @param c
     */
    void printCollectionWildcard(Collection<?> c) {
        for (Object e : c)
            System.out.println(e);

        Collection<?> col = new ArrayList<>();
        // We get a compilation error here, because the wildcard does not specify any type
//        col.add(new Object());

        // We can only add "null", but getters and setter works because the compiler can interpret it as Object.
        col.add(null);

        // This works but we use casting and it's not ok again
        List<?> someList = new ArrayList<String>();
        ((ArrayList<String>)someList).add("a string");
        Object item = someList.getFirst();
    }

}
