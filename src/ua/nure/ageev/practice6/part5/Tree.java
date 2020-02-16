package ua.nure.ageev.practice6.part5;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Tree<E extends Comparable<E>> {

    private Node<E> root;

    public boolean add(E element) {
        if (contains(element)) {
            return false;
        } else {
            root = addRecursive(root, element);
        }
        return true;
    }

    public void add(E[] elements) {

        Arrays.stream(elements).forEach(e -> this.add(e));
    }

    /**
     * Removes the specified node and its associated value from this collection
     * (if the Node exist in this collection).
     *
     * @param  @element the element
     */

    public boolean remove(E element) {
        if (!contains(element)) {
            return false;
        } else {
            delete(root, element);
            return true;
        }
    }

    private Node<E> delete(Node<E> x, E value) {
        if (x == null) return null;

        int cmp = value.compareTo(x.getValue());
        if (cmp < 0) x.left = delete(x.left, value);
        else if (cmp > 0) x.right = delete(x.right, value);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        //      x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    private Node<E> min(Node<E> node) {
        if (node.left == null) return node;
        else return min(node.left);
    }

    /**
     * Removes the smallest node from collection.
     *
     * @throws @NoSuchElementException if collection is empty
     */
    private Node<E> deleteMin(Node<E> node) {
        if (root == null) {
            throw new NoSuchElementException("Symbol table underflow");
        }
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }

    /**
     * Prints collection according to task.
     */
    public void print() {
        traverseInOrder(root, "");
    }

    /**
     * Does this symbol table contain the given value?
     *
     * @param value the value
     * @return {@code true} if this collection contains {@code value} and
     * {@code false} otherwise
     * @throws IllegalArgumentException if {@code value} is {@code null}
     */
    public boolean contains(E value) {
        if (value == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(value) != null;
    }

    public E get(E value) {
        return get(root, value);
    }

    private E get(Node<E> x, E value) {
        if (x == null) {
            return null;
        }
        int cmp = value.compareTo(x.getValue());
        if (cmp < 0) {
            return get(x.left, value);
        } else if (cmp > 0) {
            return get(x.right, value);
        } else {
            return x.getValue();
        }
    }

    public void traverseInOrder(Node<E> node, String str) {
        if (node == null) {
            return;
        }
        traverseInOrder(node.getLeft(), str + "  ");
        System.out.println(str + node.getValue());
        traverseInOrder(node.getRight(), str + "  ");
    }

    private Node<E> addRecursive(Node<E> current, E value) {
        if (current == null) {
            return new Node(value);
        }
        if (value.compareTo(current.getValue()) < 0) {
            current.left = addRecursive(current.left, value);
        } else if (value.compareTo(current.getValue()) > 0) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }
        return current;
    }

    private static class Node<E> {
        private E value;
        private Node<E> left;
        private Node<E> right;

        Node(E value) {
            this.value = value;
        }

        public Node(E value, Node<E> left, Node<E> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }
    }
}
