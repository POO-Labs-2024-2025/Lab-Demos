package org.example.example_three;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Visitor interface for operations on Elements
interface Visitor {
    void visitItem(Item item, char operation);

    void visitLista(Lista lista, char operation);
}

// Concrete Visitor for handling queries
class ElementVisitor implements Visitor {
    @Override
    public void visitItem(Item item, char operation) {
        switch (operation) {
            case '-':
                item.setAscuns(true);
                break;
            case '+':
                item.setAscuns(false);
                break;
            default:
                throw new IllegalArgumentException("Invalid operation for Item: " + operation);
        }
    }

    @Override
    public void visitLista(Lista lista, char operation) {
        switch (operation) {
            case '-':
                lista.setAscuns(true);
                break;
            case '+':
                lista.setAscuns(false);
                break;
            case '?':
                System.out.println(lista.getNume() + ": lungime=" + lista.getLungime() + " dimensiune=" + lista.getDimensiune());
                break;
            default:
                throw new IllegalArgumentException("Invalid operation for Lista: " + operation);
        }
    }
}

// Abstract base class for elements
abstract class Element {
    private final String nume;
    private boolean ascuns;

    public Element(String nume) {
        this.nume = nume;
        this.ascuns = false;
    }

    public String getNume() {
        return nume;
    }

    public boolean isAscuns() {
        return ascuns;
    }

    public void setAscuns(boolean ascuns) {
        this.ascuns = ascuns;
    }

    public abstract void accept(Visitor visitor, char operation);
}

// Class representing a single item
class Item extends Element {
    public Item(String nume) {
        super(nume);
    }

    @Override
    public void accept(Visitor visitor, char operation) {
        visitor.visitItem(this, operation);
    }
}

// Class representing a list of elements
class Lista extends Element {
    private final List<Element> elemente;

    public Lista(String nume) {
        super(nume);
        this.elemente = new ArrayList<>();
    }

    public void addElement(Element element) {
        elemente.add(element);
    }

    public void addAll(List<Element> elements) {
        elemente.addAll(elements);
    }

    public int getLungime() {
        int count = 0;
        for (int i = 0; i < elemente.size(); i++) {
            if (!elemente.get(i).isAscuns()) {
                count++;
            }
        }
        return count;
    }

    public int getDimensiune() {
        return elemente.size();
    }

    @Override
    public void accept(Visitor visitor, char operation) {
        visitor.visitLista(this, operation);
    }
}

// Main class to initialize and handle queries
public class Solution {
    private final List<Element> elements = new ArrayList<>();

    public static void main(String[] args) {
        Solution sol = new Solution();
        Lista root = sol.init();
        sol.handleQueries(root);
    }

    public Lista init() {
        Lista A = new Lista("A");
        elements.add(A);

        // Add elements directly to the main list
        A.addAll(List.of(
                new Item("a1"),
                new Item("a2")
        ));

        Lista E = new Lista("E");
        A.addElement(E);

        E.addAll(List.of(
                new Item("e1"),
                new Item("e2"),
                new Item("e3"),
                new Item("e4"),
                new Item("e5"),
                new Item("e6")
        ));

        A.addElement(new Item("a3"));

        Lista F = new Lista("F");
        A.addElement(F);

        F.addAll(List.of(
                new Item("f1"),
                new Item("f2")
        ));

        // Add all to the global registry
        elements.addAll(List.of(A, E, F));
        return A;
    }

    private Element findElementByName(String name) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getNume().equals(name)) {
                return elements.get(i);
            }
        }
        throw new IllegalArgumentException("Element " + name + " nu a fost definit");
    }

    public void handleQueries(Lista root) {
        Scanner scanner = new Scanner(System.in);
        Visitor visitor = new ElementVisitor();
        try {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                char op = line.charAt(0);
                String elemName = line.substring(1).trim();

                Element elem = findElementByName(elemName);
                elem.accept(visitor, op);
            }
        } catch (Exception e) {
            System.out.println("Eroare: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

