/****************************************************************
 * 
 *     public class MinPQ(int)<Key> implements Iterable<Key>:
 *          private Key[] pq;
 *          private int n;
 *          private Comparator<Key> comparator;
 *          public boolean isEmpty();
 *          public int size();
 *          public Key min();
 *          private void resize(int);
 *          public void insert(Key);
 *          public Key delMin();
 *          private void swim(int);
 *          private void sink(int);
 * 
 ****************************************************************/

 import java.util.Iterator;
 import java.util.Comparator;
 import java.util.NoSuchElementException;


public class MinPQ<Key extends Comparable<Key>>implements Iterable<Key> {
    private Key[] pq;
    private int n;
    private Comparator<Key> comparator;
    public MinPQ(int capacity) {
        pq = (Key[]) new Object[capacity + 1];
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public Key min() {
        if(isEmpty())   throw new NoSuchElementException("PQ underflow!");
        return pq[1];
    }
    
    private void resize(int capacity) {
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity];
        for(int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    public void insert(Key x) {
        if(n == pq.length - 1)  resize(2 * pq.length);
        pq[++n] = x;
        swim(n);
    }

    private void swim(int k) {
        while(k > 1 && pq[k].compareTo(pq[k / 2]) > 0) {
            swap(pq, k, k / 2);
            k = k / 2;
        }
    }

    private swap(Key[] k, Key i, Key j) {
        Key temp = k[i];
        k[i] = k[j];
        k[j] = temp;
    }
}
