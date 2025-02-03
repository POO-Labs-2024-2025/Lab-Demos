package iterator;

import data_structure.BinarySearchTree;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class PreOrderIterator<T> implements Iterator<T> {
    // We use a stack for this
    private final Stack<BinarySearchTree.Node<T>> stack = new Stack<>();

    public PreOrderIterator(BinarySearchTree.Node<T> root) {
        if (root != null) {
            stack.push(root);
        }
    }

    /**
     * Detect if we have a node
     *
     * @return true or false
     */
    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * Go to the next element
     *
     * @return next element which is generic
     */
    @Override
    public T next() {
        // Always use exceptions
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        // Preorder
        BinarySearchTree.Node<T> node = stack.pop();
        if (node.getRight() != null) {
            stack.push(node.getRight());
        }
        if (node.getLeft() != null) {
            stack.push(node.getLeft());
        }

        // Return value
        return node.getKey();
    }
}
