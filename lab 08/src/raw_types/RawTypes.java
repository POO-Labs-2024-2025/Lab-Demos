package raw_types;

import java.util.ArrayList;
import java.util.List;

public class RawTypes {
    void foo() {
        // This uses a raw type since we don't add the "<>" with the types inside
        List list1 = new ArrayList();
        list1.add(0);

        // Why are raw types bad? Because we have to cast here, which also means that we can get errors if the list does
        // not actually contain integers
        Integer x = (Integer) list1.getFirst();

        // But if we use the types, we solve this completely, keep in mind we only need to add Integer to the left member.
        // This is done at compile time using generic types
        List<Integer> list2 = new ArrayList<>();
        list2.add(0);
        Integer y = list2.getFirst();

        // Why don't we need to specify the type on the right? Because Java Collections are invariants, that means the
        // compiler infers the type, even if we should technically pass the type for ArrayList as well (this ties with the
        // subtype errors).
        List<String> list3 = new ArrayList<>();
    }
}
