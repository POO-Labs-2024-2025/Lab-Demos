package org.example.example_two;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Base class representing an element
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

    public abstract void handleQuery(char op);
}

// Class representing a single element
class Item extends Element {
    public Item(String nume) {
        super(nume);
    }

    @Override
    public void handleQuery(char op) {
        switch (op) {
            case '-':
                setAscuns(true);
                break;
            case '+':
                setAscuns(false);
                break;
            default:
                throw new IllegalArgumentException("Invalid operation for Item: " + op);
        }
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
    public void handleQuery(char op) {
        switch (op) {
            case '-':
                setAscuns(true);
                break;
            case '+':
                setAscuns(false);
                break;
            case '?':
                System.out.println(getNume() + ": lungime=" + getLungime() + " dimensiune=" + getDimensiune());
                break;
            default:
                throw new IllegalArgumentException("Invalid operation for Lista: " + op);
        }
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
        addElementsToRegistry(List.of(A, E, F));
        return A;
    }

    private void addElementsToRegistry(List<Element> newElements) {
        elements.addAll(newElements);
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
        try {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                char op = line.charAt(0);
                String elemName = line.substring(1).trim();

                Element elem = findElementByName(elemName);
                elem.handleQuery(op);
            }
        } catch (Exception e) {
            System.out.println("Eroare: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
