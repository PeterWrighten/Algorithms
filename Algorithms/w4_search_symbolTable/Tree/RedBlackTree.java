/************************************************************
 * 
 *  public class RedBlackTree<Key extends Comparable<Key>, Value>:
 *      private static final boolean RED = true;
 *      private static final boolean BLACK = false;
 *      private class Node(Key key, Value value){
 *          Key key;
 *          Value value;
 *          Node left, right;
 *          boolean color;
 *          int count;
 *      };
 *      private Node root;
 *      private boolean isRed(Node);
 *      private Node rotateLeft(Node);
 *      private Node rotateRight(Node);
 *      private void flipColors(Node);
 *      public void put(Node, Key, Value);
 *      public Value get(Key);
 *      private Node delMin(Node, Key);
 *      public void delete(Key);
 *      public Iterable<Key> keys();
 *      
 ************************************************************/

import java.lang.Comparable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.NoSuchElementException;


public class RedBlackTree<Key extends Comparable<Key>, Value>{
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    
    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private boolean color;
        private int count;
        public Node(Key key, Value value, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }

    private Node root;

    private boolean isRed(Node x) {
        if(x == null) return false; //null links are black.
        return x.color == RED;
    }

    private int size(Node x) {
        if(x == null) return 0; 
        return x.count;
    }
    
    private Node rotateLeft(Node h) {
        assert isRed(h.right);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h) {
        assert isRed(h.left);
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColors(Node h) {
        assert !isRed(h);
        assert isRed(h.right);
        assert isRed(h.left);
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }


    private Node put(Node h, Key key, Value value) {
        if(h == null) return new Node(key, value, RED);
        int cmp = key.compareTo(h.key);
        if(cmp < 0)     h.left = put(h.left, key, value);
        else if(cmp > 0)    h.right = put(h.right, key, value);
        else    h.value = value;
        if(isRed(h.right) && !isRed(h.left))    h = rotateLeft(h);
        if(isRed(h.left) && isRed(h.left.left))     h = rotateRight(h);
        if(isRed(h.left) && isRed(h.right))     flipColors(h);
        h.count = size(h.left) + size(h.right) + 1;
        return h;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node get(Node x, Key key) {
        if( x == null ) return null;
        int cmp = key.compareTo(x.key);
        if(cmp > 0)  return get(x.right, key);
        else if( cmp < 0 ) return get(x.left, key);
        else   return x;
    }

    public Value get(Key key) {
        Node x = get(root, key);
        if(x == null)  return null;
        return x.value;
    }

    private Node delMin(Node x) {
        if(x.left == null)   return null;
        x.left = delMin(x.left);
        return x;
    }

    public Iterable<Key> keys() {
        Node x = root;
        Queue<Key> q = new LinkedList<Key>();
        inorder(x, q);
        return q;
    }

    private void inorder(Node x, Queue<Key> q) {
        if(x == null) return;
        inorder(x.left, q);
        q.add(x.key);
        inorder(x.right, q);
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if( x == null ) return null;
        int cmp = key.compareTo(x.key);
        if( cmp > 0)    x.right = delete(x.right, key);
        else if(cmp < 0)    x.left = delete(x.left, key);
        else {
            Node old = x; 
            x = min(old.right); 
            x.left = old.left; 
            x.right = delMin(old.right);
        }
        x.count = 1 + size(x.left) + size(x.right);
        if(isRed(x.right) && !isRed(x.left))    x = rotateLeft(x);
        if(isRed(x.left) && isRed(x.left.left)) x = rotateRight(x);
        if(isRed(x.left) && isRed(x.right))     flipColors(x);

        return x;

    }

    private Node min(Node x) {
        if(x.left == null)   return x;
        return min(x.left);
    }

    public String min() {
        String NEWLINE = System.getProperty("line.separator");
        StringBuilder min = new StringBuilder();
        Node x = min(root);
        if(x == null) throw new NoSuchElementException();
        min.append("Key: " + x.key);
        min.append("Value: " + x.value);
        min.append(NEWLINE);
        return min.toString();
    }

    private Node max(Node x) {
        if(x.right == null) return x;
        return max(x.right);
    }

    public String max() {
        String NEWLINE = System.getProperty("line.separator");
        StringBuilder max = new StringBuilder();
        Node x = max(root);
        max.append("Key: " + x.key);
        max.append("Value: " + x.value);
        max.append(NEWLINE);
        return max.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        RedBlackTree<String, String> tree = new RedBlackTree<String, String>();
        while(true) {
            System.out.println("----------------------------");
            System.out.println("0. Exit");
            System.out.println("1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Delete");
            System.out.println("4. Min");
            System.out.println("5. Max");

            int q = input.nextInt();
            switch (q) {
                case 0:
                    input.close();
                    System.exit(0);

                case 1:
                    System.out.println("Input Key(Word): ");
                    String key = input.next();
                    System.out.println("Input Value(Word): ");
                    String val = input.next();
                    tree.put(key, val);
                    break;

                case 2:
                    System.out.println("Input Query Key: ");
                    String query = input.next();
                    String res = tree.get(query);
                    System.out.println("Value: " + res);
                    break;

                case 3:
                    System.out.println("Input delete Key: ");
                    String del = input.next();
                    tree.delete(del);
                    break;
                case 4:
                    System.out.println("Min KV is: ");
                    System.out.println(tree.min());
                    break;
                case 5:
                    System.out.println("Max KV is: ");
                    System.out.println(tree.max());

                default:
                    break;

            }

        }

    }
    
}
