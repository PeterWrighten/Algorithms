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
 *      
 ************************************************************/




public class RedBlackTree<Key extends Comparable<Key>, Value>{
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    
    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private boolean color;
        private int count;
    }

    private Node root;

    private boolean isRed(Node x) {
        if(x == null) return false; //null links are black.
        return x.color == RED;
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
}
