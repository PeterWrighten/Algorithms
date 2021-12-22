
/*******************************************************************************
 * 
 *  public class BinarySearchTree<Key extends Comparable<Key>, Value>:
 *      private Node root;
 *      private class Node;
 *      public void put(Key key, Value value);
 *      public Value get(Key key);
 *      public Iterable<Key> keys();
 *      public Key floor(Key key);
 *      public Key ceil(Key key);
 *      public int size();
 *      public int rank(Key key);
 *      public void delete(Key key);
 *      public void delMin();
 *      
 ********************************************************************************/



import java.util.Iterator;
import java.lang.Comparable;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if(x == null) return new Node(key, value);
        int cmp = key.compareTo(x.key);
        if(cmp == 0)    x.value = value;
        else if(cmp < 0)     x.left = put(x.left, key, value);
        else if(cmp > 0)     x.right = put(x.right, key, value);
        return x;
    }


    public Value get(Key key) {
        Node x = root;
        while(x != null) {
            int cmp = key.compareTo(x.key);
            if(cmp < 0) x = x.left;
            else if(cmp > 0)  x = x.right;
            else  return x.value;
        }
        return null;
    }
}
