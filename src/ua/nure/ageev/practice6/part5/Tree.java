package ua.nure.ageev.practice6.part5;

public class Tree<E extends Comparable<E>>{

    public boolean add(E element) { return false;}

    public void add(E[] elements) {}

    public boolean remove(E element) {
        return false;
    }

    public void print() {}

    private static class Node<E> {}
}
