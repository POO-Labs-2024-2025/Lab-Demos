package bounded_wildcards;

import java.util.ArrayList;
import java.util.List;

class Pizza {
    protected String name = "Pizza";

    public String getName() {
        return name;
    }
}

class HamPizza extends Pizza {
    public HamPizza() {
        name = "HamPizza";
    }
}

class CheesePizza extends Pizza {
    public CheesePizza() {
        name = "CheesePizza";
    }
}

public class Main {
    /**
     * This List<? extends Class> means that we allow Class or its children.
     * (going down and from the class that means Upper Bounded Wildcard)
     * We use Upper Bounded Wildcard to modify a collection.
     *
     * We can also do List<? super Class> means Class or a super class of Class
     * (going up and from the class that means Lower Bounded Wildcard)
     * We use Lower Bounded Wildcard to iterate a collection without modifying.
     *
     * @param pizzaList
     */
    public static void listPizza(List<? extends Pizza> pizzaList) {
        for(Pizza item : pizzaList)
            System.out.println(item.getName());
    }

    public static void main(String[] args) {
        List<Pizza> pizzaList = new ArrayList<>();

        pizzaList.add(new HamPizza());
        pizzaList.add(new CheesePizza());
        pizzaList.add(new Pizza());
    }
}

