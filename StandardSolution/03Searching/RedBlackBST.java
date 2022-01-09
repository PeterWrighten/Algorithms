
/****************************************************************************
 *   # Left-leaning RedBlackBST
 *  
 *   public class RedBlackBST<key extends Comparable<Key>, Value>:
 *      private static final boolean RED = true;
 *      private static final boolean BLACK = false;
 *      private class Node{
 *          Key key;
 *          Value value;
 *          Node left, right;
 *          boolean color;
 *          int size;
 *      }
 *      private boolean isRed(Node);
 *      private int size(Node);
 *      public int size();
 *      public boolean isEmpty();
 *      private Value get(Node, Key);
 *      public boolean contains(Key);
 *      private Node put(Node, Key, Value);
 *      private Node deleteMin(Node);
 *      private Node deleteMax(Node);
 *      private Node delte(Node, Key);
 *      private Node rotateRight(Node);
 *      private Node rotateLeft(Node);
 *      private void flipColors(Node);
 *      private Node moveLeft(Node);
 *      private Node moveRight(Node);
 *  --> private Node balance(Node);  
 *      private int height(Node);
 *      private Node min(Node);
 *      private Node max(Node);
 *      private Node floor(Node, Key);
 *      private Node ceiling(Node, Key);
 *      private Key select(Node, int);
 *      private int rank(Key, Node);
 *      public Iterable<Key> keys(Key, Key);
 *      private void keys(Node, Queue<Key>, Key, Key);
 *      public int size(Key, Key);
 *      private boolean check();
 *      private boolean isBST(Node, Key, Key);
 *      private boolean isSizeConsistent(Node);
 *      private boolean isRankConsistent();
 *      private boolean is23(Node);
 *      private boolean isBalanced(Node, int);
 * 
 ****************************************************************************/



import java.lang.Comparable;
import java.util.NoSuchElementException;

public class RedBlackBST<Key extends Comparable<Key>, Value>{
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;
    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private boolean color;
        private int size;
        public Node(Key key, Value value, boolean color, int size) {
            this.key = key;
            this.value = value;
            this.color = color;
            this.size = size;
        }
    }

    private boolean isRed(Node x) {
        if(x == null)   return false;
        return x.color == RED;
    }

    private int size(Node x) {
        if(x == null) return 0;
        return x.size;
    }

    public int size() {
        return size(root);
    }

    public boolean isEmpty() {
        return root == null;
    }

    private Value get(Node x, Key key) {
        while(x != null) {
            int cmp = key.compareTo(x.key);
            if(cmp > 0) x = x.right;
            else if(cmp < 0)  x = x.left;
            else return x.value;
        }
        return null;
    }

    public Value get(Key key) {
        if(key == null) throw new IllegalArgumentException("Argument to get() is null");
        return get(root, key);
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    /****************************************************************
     *  RedBlackBST Insertion
     ****************************************************************/

    private Node put(Node x, Key key, Value value) {
        if( x == null) return new Node(key, value, RED, 1);
        int cmp = key.compareTo(x.key);
        if(cmp > 0) x.right = put(x.right, key, value);
        else if(cmp < 0) x.left = put(x.left, key, value);
        else   x.value = value;

        if(!isRed(x.left) && isRed(x.right))    x = rotateLeft(x);
        if( isRed(x.left) && isRed(x.left.left))  x = rotateRight(x);
        if(isRed(x.left) && isRed(x.right))     flipColors(x);
        x.size = size(x.left) + size(x.right) + 1;

        return x;
    }

    public void put(Key key, Value value) {
        if(key == null) throw new IllegalArgumentException("First argument to put() is null");
        if(value == null) {
            delete(key);
            return;
        }
        root = put(root, key, value);
        root.color = BLACK;
    }

    /********************************************************
     *  RedBlack BST deletion
    *********************************************************/

    private Node deleteMin(Node h) {
        if(h.left == null)
            return null;
        
        if(!isRed(h.left) && !isRed(h.left.left))
            h = moveRedLeft(h);

        h.left = deleteMin(h.left);
        return balance(h);
    }

    public void deleteMin() {
        if(isEmpty())   throw new NoSuchElementException("BST underflow");

        if(!isRed(root.left) && !isRed(root.right)) 
            root.color = RED;
        
        root = deleteMin(root);
        if(!isEmpty())  root.color = BLACK;
    }

    private Node min(Node x) {
        if(x.left == null) return x;
        return min(x.left);
    }

    private Node delete(Node h, Key key) {
        //assert get(h, key) != null;

        if(key.compareTo(h.key) < 0) {
            if(!isRed(h.left) && !isRed(h.left.left))
                h = moveRedLeft(h);
            h.left = delete(h.left, key);
        }
        else {
            if(isRed(h.left))
                h = rotateRight(h);
            
            /****************************************************************************
             * 
             *  Property: 
             *      Assume a Node h;
             *      iff h is a leaf, h.left.color == BLACK && h.right == null; 
             * 
             ****************************************************************************/ 
            if(key.compareTo(h.key) == 0 && (h.right == null))
                return null;
            if(!isRed(h.right) && !isRed(h.right.left))
                h = moveRedRight(h);
            if(key.compareTo(h.key) == 0) {
                Node x = min(h.right);
                h.key = x.key;
                h.value = x.value;
                h.right = deleteMin(h.right);
            }
            else h.right = delete(h.right, key);
        }
        return balance(h);
        
    }

    public void delete(Key key) {
        if(key == null) throw new IllegalArgumentException("Argument to delete() is null");
        if(!contains(key))  return;

        if(!isRed(root.left) && !isRed(root.right)) 
            root.color = RED;
        root = delete(root, key);
        if(!isEmpty())  root.color = BLACK;
    }


    /********************************************************
     * 
     *   Red-Black Tree helper functions.
     * 
     ********************************************************/

    private Node rotateRight(Node x) {
        assert (x != null) && isRed(x.left);
        Node t = x.left;
        x.left = t.right;
        t.right = x;
        t.color = x.color;
        x.color = RED;
        return t;
    }

    private Node rotateLeft(Node x) {
        assert (x != null) && isRed(x.right);
        Node t = x.right;
        x.right = t.left;
        t.left = x;
        t.color = x.color;
        x.color = RED;
        return t;
        
    }

    private void flipColors(Node x) {
        x.color = !x.color;
        x.left.color = !x.left.color;
        x.right.color = !x.right.color;
    }

    private Node moveRedLeft(Node h) {
        //assert(h != null);
        //assert isRed(h) && !isRed(h.left) && !isRed(h.left.left);

        flipColors(h);
        if (isRed(h.right.left)) {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
            flipColors(h);
        }
        return h;
    }

    private Node moveRedRight(Node h) {
        //assert(h != null);
        //assert isRed(h) && !isRed(h.right) && !isRed(h.right.left);
        if(isRed(h.left.left)) {
            h = rotateRight(h);
            flipColors(h);
        }
        return h;
    }

    private Node balance(Node h) {
        //assert(h != null);

        if(isRed(h.right) && !isRed(h.left))    h = rotateLeft(h);
        if(isRed(h.left) && isRed(h.left.left))     h = rotateRight(h);
        if(isRed(h.left) && isRed(h.right))     flipColors(h);
        h.size = size(h.left) + size(h.right) + 1;
        return h;
    }

}
