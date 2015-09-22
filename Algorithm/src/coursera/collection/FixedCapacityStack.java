package coursera.collection;

import java.util.Iterator;

/**
 * Created by milanashara on 22/9/2015.
 */
public class FixedCapacityStack<Item> implements Iterable<Item> {
    private Item[] s;
    private int N = 0;

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    public FixedCapacityStack(int capacity) {
        //s = new Item[capacity]; @#$*! generic array creation not allowed in Java
        s = (Item[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(Item item) {
        s[N++] = item;
    }

    public Item pop() {
        return s[--N];
    }

    public class ReverseArrayIterator implements Iterator<Item> {

        private int i = N;

        public boolean hasNext() {
            return i > 0;
        }

        public void remove() { /* not supported */ }

        public Item next() {
            return s[--i];
        }
    }
}
