package type_erasure;

import java.util.List;

public class BadExample<T> {
    void genericFunction(List<String> stringList) {
        stringList.add("foo");
    }
}

// Can you guess why it does not work?
class Test {
//    public static void main(String[] args) {
//        GenericClass genericClass = new GenericClass();
//        List<Integer> integerList = new ArrayList<Integer>();
//
//        integerList.add(100);
//        genericClass.genericFunction(integerList);
//
//        System.out.println(integerList.get(0)); // 100
//        System.out.println(integerList.get(1)); // foo
//    }
}
