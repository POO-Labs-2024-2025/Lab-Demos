package data_structure;

import iterator.PreOrderIterator;

/**
 * This generic type allows all types that have the Comparable class extended (which mean they already have implemented
 * a custom comparator so we won't have to scratch our head with that concept as well).
 *
 * @param <T> generic type
 */
public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root; // root node where everything starts

    /**
     * Internal class where we specify what we want to store and the Tree relation (left <- root -> right)
     * Note: don't generate getters or setters if you don't need to
     *
     * @param <T> type of data we want to store
     */
    public static class Node<T> {
        private final T key;
        private Node<T> left, right;

        Node(T key) {
            this.key = key;
        }

        public T getKey() {
            return key;
        }

        public Node<T> getLeft() {
            return left;
        }

        public Node<T> getRight() {
            return right;
        }
    }

    /**
     * This method is publicly accessible, which means this is what we expose. A simple method that adds a key. The
     * user does not need to know where and how we add it so let's hide this.
     *
     * @param key key to be added with generic type
     */
    public void add(T key) {
        root = addRecursive(root, key);
    }

    /**
     * This is private since here is where our logic happens and usually when we work recursively we need two methods:
     * - one that starts the process (in our case `add`)
     * - one that goes recursively (this method)
     * Note: you don't need to go recursive, you could have done it iteratively with a Stack
     *
     * @param current current node where we are
     * @param key key to be added
     * @return the added node
     */
    private Node<T> addRecursive(Node<T> current, T key) {
        if (current == null) {
            return new Node<>(key);
        }

        /*
         * Ignore duplicate keys
         *
         * Also notice something awesome, we don't need to declare custom comparators because of our generic extends
         * property. For example, all primitives have already defined comparators so String, Integer, Float have implemented
         * the class Comparator so our code is really minimal.
         */
        int cmp = key.compareTo(current.key);
        if (cmp < 0) {
            current.left = addRecursive(current.left, key);
        } else if (cmp > 0) {
            current.right = addRecursive(current.right, key);
        }

        return current;
    }

    /**
     * We want to return an iterator for our tree as well. Why? Because we can make sure we have a homogenous iterator
     * with the type of tree we created.
     *
     * @return the return type will have our class type so the iterator will be the same as the Tree when we create it
     */
    public PreOrderIterator<T> preOrderIterator() {
        return new PreOrderIterator<>(root);
    }
}
