/****************************************************************
 * Essence:
 * 
 *        In Trie Symbol Table, The index of 'next' Node array represents the next character,
 *        and The value of Whole Node represents the value.
 * 
 ****************************************************************/



public class TrieST<Value> {
    private static final int R = 256;

    private Node root;
    private int n;
    private static class Node {
        private Object value;
        private Node[] next = new Node[R];
    }

    private Node get(Node x, String key, int d) {
        if( x == null ) return null;
        if( d == key.length()) {
            return x;
        }
        char c = key.charAt(d);
        return get(x.next[c], key, d+1);
    }

    public Value get(String key) {
        if(key == null) throw new IllegalArgumentException("argument to get() is null");
        Node x = get(root, key, 0);
        if(x == null) return null;
        return (Value)x.value;
    }

    public boolean contains(String key) {
        if(key == null)  throw new IllegalArgument("argument to contains() is null");
        return get(key) != null;
    }

    public int size() {
        return n;
    }

    private Node put(Node x, String key, Value value, int d) {
        if(x == null)   return new Node();
        if(d == key.length()) {
            if(x.value == null) n++;
            x.value = value;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, value, d+1);
        return x;
    }

    public void put(String key, Value value) {
        if(key == null) throw new IllegalArgument("argument to put() is null");
        if(value == null)   delete(key);
        else    root = put(root, key, value, 0);
    }

    private Node delete(Node x, String key, int d) {
        /* Twice constraints. */      

        if( x == null ) return null;

        /* 1. make absort: d == key.length() */

        if(d == key.length()) {
            if(x.value != null) n--;
            x.value = null;
        }
        else {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d+1);
        }

        /* 2. delete all or just make null: x.value == null && x.next[] == null */

        /* remove subtrie if completely empty; Constraint: "return x;" 
         * if x.value == null && x.next[] == null, delete all; else just make x.value = null. */

        if(x.value != null)   return x; 
        for(int c = 0; c < R; c++) 
            if(x.next[c] != null)
                return x;
        return null;      
    }

    public void delete(String key) {
        if(key == null) throw new IllegalArgumentException("argument to delete() is null");
        root = delete(root, key, 0);
    }
}
