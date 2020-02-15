package ua.nure.ageev.practice6.part4;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Range implements Iterable<Integer> {
    private final int begin;
    private final int end;
    private boolean reverse;

    public Range(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    public Range(int begin, int end, boolean reverse) {
        this(begin, end);
        this.reverse = reverse;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new IteratorRange();
    }

    private class IteratorRange implements Iterator<Integer> {
        private int cursor;

        IteratorRange() {
            this.cursor = reverse ? end + 1 : begin - 1;
        }

        @Override
        public boolean hasNext() {
            return reverse ? cursor > begin : cursor < end;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return reverse ? --cursor : ++cursor;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
