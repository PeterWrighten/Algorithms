import api.String;

/***********************************************************************
 * 
 *     public class TrieST<Value>:
 *          private static final int R;
 *          private Node root;
 *          private int size;
 *          private static class Node {
 *              private Object value;
 *              private Node[] next;
 *          }
 *          private Node put(Node x, String key, Value val, int d);
 *          public void put(String key, Value val);
 *          private Node get(Node x, String key, int d);
 *          public Value get(String key);
 *          public boolean contains(String key);
 *          private Node delete(Node, String, int);
 *          public void delete(String key);
 * 
 ***********************************************************************/



public class TrieST<Value> {
    private static final int R = 256;
    private Node root = new Node();
    private int size = 0;

    private static class Node {
        private Object value;
        private Node[] next = new Node[R];
    }

    private Node put(Node x, String key, Value val, int d) {
        if( x == null )     x = new Node();
        if( d == key.length() ) {
            if(x.value == null) size++;
            x.value = val;
            return x;
        }
        char c = key.charAt(d);// Cast to ASCII Value when make it as index.
        x.next[c] = put(x.next[c], key, val, d+1);
        return x;  
    }

    public void put(String key, Value val) {
        if(x.value == null) delete(key);
        else    root = put(root, key, val, 0);
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

    private Node delete(Node x, String key, int d) {
        if( x == null ) return null;

        if(d == key.length()) {
            if(x.value != null)  size--;
            x.value = null;
        }
        else {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d+1);
        }

        if(x.value != null) return x;
        for (int c = 0; c < R; c++) {
            if(x.next[c] != null) {
                return x;
            }
        }
        return null;
    }

    public void delete(String key) {
        root = delete(root, key, 0);
    }
    
}
