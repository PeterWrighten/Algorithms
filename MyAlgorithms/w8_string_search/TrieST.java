import api.String;

/***********************************************************************
 * 
 *     public class TrieST<Value>:
 *          private static final int R;
 *          private Node root;
 *          private static class Node {
 *              private Object value;
 *              private Node[] next;
 *          }
 *          private Node put(Node x, String key, Value val, int d);
 *          public void put(String key, Value val);
 *          private Node get(Node x, String key, int d);
 *          public Value get(String key);
 *          public boolean contains(String key);
 * 
 ***********************************************************************/



public class TrieST<Value> {
    private static final int R = 256;
    private Node root = new Node();

    private static class Node {
        private Object value;
        private Node[] next = new Node[R];
    }

    private Node put(Node x, String key, Value val, int d) {
        if( x == null )     x = new Node();
        if( d == key.length() ) {
            x.value = val;
            return x;
        }
        char c = key.charAt(d);// Cast to ASCII Value when make it as index.
        x.next[c] = put(x.next[c], key, val, d+1);
        return x;  
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node get(Node x, String key, int d) {
        if( x == null )     return null;
        if(d == key.length()) {
            return x;
        }
        char c = key.charAt(d);
        return get(x.next[c], key, d+1);
    }

    public Value get(String key) {
        Node x = get(root, key, 0);
        if( x == null ) return null;
        return (Value)x.value;
    }
    
}
