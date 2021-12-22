
/*******************************************************************************
 * 
 *  public class BinarySearchTree<Key extends Comparable<Key>, Value>:
 *      private Node root;
 *      private class Node;
 *      public void put(Key key, Value value);
 *      public Value get(Key key);
 *      public Iterable<Key> keys();
 *      [*]public Key floor(Key key);
 *      public Key ceil(Key key);
 *      public int size();
 *      public int rank(Key key);
 *      [*]public void delete(Key key);
 *      public void delMin();
 *      
 ********************************************************************************/



import java.util.Scanner;
import java.lang.Comparable;
import java.util.Queue;
import java.util.LinkedList;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int count;
        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

    }

    private int size(Node x) {
        if(x == null) return 0;
        return x.count;
    }

    public int size() {
        return size(root);
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
        x.count = 1 + size(x.left) + size(x.right);
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

    // Floor: Largest key <= a given key.
    public Key floor(Key key) {
        Node x = floor(root, key);
        if(x == null)  return null;
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if(x == null)   return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0)    return x;
        if(cmp < 0)    return floor(x.left, key);
        Node t = floor(x.right, key);
        if(t == null)   return x;
        else return t;
    }

    // Smallest key >= a given key.
    public Key ceil(Key key) {
        Node x = ceil(root, key);
        if(x == null) return null;
        return x.key;
    }

    private Node ceil(Node x, Key key) {
        if(x == null)  return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0) return x;
        if(cmp > 0)  return ceil(x.right, key);
        Node tmp = ceil(x.left, key);
        if(tmp == null)  return x;
        else return tmp;
    }

    // Rank: How many keys < k?
    private int rank(Node x, Key key) {
        if(x == null) return 0;
        int cmp = key.compareTo(x.key);
        if(cmp == 0) return size(x.left);
        else if(cmp < 0) return rank(x.left, key);
        else return 1 + size(x.left) + rank(x.right, key);

    }

    public int rank(Key key) {
        return rank(root, key);
    }

    public Iterable<Key> keys() {
        Queue<Key> q = new LinkedList<Key>();
        inorder(root, q);
        return q;
    }

    private void inorder(Node x, Queue<Key> q) {
        if(x == null) return;
        inorder(x.left, q);
        q.add(x.key);
        inorder(x.right, q);
    }

    public void delMin() {
        root = delMin(root);
    }

    private Node delMin(Node x) {
        if(x.left == null) return x.right;
        x.left = delMin(x.left);
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    private Node min(Node x) {
        if(x.left == null)  return x;
        return min(x.left);
    }

    public String min() {
        Node x = min(root);
        StringBuilder s = new StringBuilder();
        String NEWLINE = System.getProperty("line.separator");
        s.append("Key: " + x.key + ", ");
        s.append("Value: " + x.value + ". ");
        s.append(NEWLINE);
        return s.toString();
    }

    private Node max(Node x) {
        if(x.right == null) return x;
        return max(x.right);
    }

    public String max() {
        Node x = max(root);
        StringBuilder s = new StringBuilder();
        String NEWLINE = System.getProperty("line.separator");
        s.append("Key: " + x.key + ", ");
        s.append("Value: " + x.value + ". ");
        s.append(NEWLINE);
        return s.toString();
    }

    // Hibbard deletion
    private Node delete(Node x, Key key) {
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp > 0)     x.right = delete(x.right, key);
        else if(cmp < 0)     x.left = delete(x.left, key); 
        else {
            Node old = x;
            x = min(old.right);
            x.left = old.left;
            x.right = delMin(old.right);
        } 
        x.count = 1 + size(x.left) + size(x.right);
        return x; 

    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BinarySearchTree<String, String> tree = new BinarySearchTree<String, String>();
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
