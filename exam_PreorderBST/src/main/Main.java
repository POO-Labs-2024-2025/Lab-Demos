package main;

import data_structure.BinarySearchTree;
import iterator.PreOrderIterator;

import java.util.Scanner;

/**
 * Do not start here. First declare your data structure, so first analyze the packet data_structure
 * Then go over the algorithm in iterator
 * Then go over how we wrap everything together in Main.
 *
 * Problems with this approach: RAW USE IS NOT ENCOURAGED.
 * However, my solution is pretty standard and easy to understand so I kept it like this. But to make sure we actually
 * do not use Raw Types we might need a factory, which is exactly what Alex Olteanu did in his official solution. So,
 * after understanding this solution go read his to see how the transition to a better solution would look like. It is
 * however important for you to start easy and slow and understand the concepts and how to think a problem like this, so
 * chew this solution however long to understand it and maintain the order of implementation just like the order of reading
 * (Data structure -> algorithm -> adding everything in main). Also it might be better maybe to start your solution without
 * going first to a generic approach, maybe start making a Tree for Integers only and after validating it works add the
 * generic type (or start first with generics, you do you).
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String keyType = scanner.nextLine();

        // We make this raw, why? Try to use <?> and realise it won't work (explained in lab)
        BinarySearchTree bst;

        // Since it is raw we can define it dynamically
        switch (keyType) {
            case "Integer":
                bst = new BinarySearchTree<Integer>();
                break;
            case "String":
                bst = new BinarySearchTree<String>();
                break;
            case "Double":
                bst = new BinarySearchTree<Double>();
                break;
            default:
                // Always have defaults, maybe try to throw an exception here
                System.out.println("Unknown key type: " + keyType);
                return;
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) continue;

            // Add keys by the Tree type, we simply call add which is great. Notice we did not use overloading, we used
            // generics so Integer, Double and String all work with the same simple method
            try {
                switch (keyType) {
                    case "Integer":
                        bst.add(Integer.parseInt(line));
                        break;
                    case "String":
                        bst.add(line);
                        break;
                    case "Double":
                        bst.add(Double.parseDouble(line));
                        break;
                    default:
                        System.out.println("Can't add key since it has unsupported type.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid key format: " + line);
                return;
            }
        }

        // Look how great it is since we return our iterator from our Tree. We assure that we won't create manually an
        // iterator that would store wrong keys by simply making the Tree return the iterator directly to us
        PreOrderIterator<?> iterator = bst.preOrderIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
