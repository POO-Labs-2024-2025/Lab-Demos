package org.example.example;

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

    public int getLungime() {
        int count = 0;
        for (Element element : elemente) {
            if (!element.isAscuns()) {
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

        addElement(A, new Item("a1"));
        addElement(A, new Item("a2"));

        Lista E = new Lista("E");
        elements.add(E);
        addElement(E, new Item("e1"));
        addElement(E, new Item("e2"));
        addElement(E, new Item("e3"));
        addElement(E, new Item("e4"));
        addElement(E, new Item("e5"));
        addElement(E, new Item("e6"));
        addElement(A, E);

        addElement(A, new Item("a3"));

        Lista F = new Lista("F");
        elements.add(F);
        addElement(F, new Item("f1"));
        addElement(F, new Item("f2"));
        addElement(A, F);

        return A;
    }

    private void addElement(Lista parent, Element child) {
        parent.addElement(child);
        elements.add(child);
    }

    private Element findElementByName(String name) {
        return elements.stream()
                .filter(e -> e.getNume().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Element " + name + " nu a fost definit"));
    }

    public void handleQueries(Lista root) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                char op = line.charAt(0);
                String elemName = line.substring(1).trim();

                Element elem = findElementByName(elemName);
                elem.handleQuery(op);
            }
        } catch (Exception e) {
            System.out.println("Eroare: " + e.getMessage());
        }
    }
}
