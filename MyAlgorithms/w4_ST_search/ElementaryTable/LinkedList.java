/****************************************************************************
 * 
 *     public class LinkedList{
 *          private class Node{
 *          }
 *     }
 * 
 ****************************************************************************/




public class LinkedList<Key, Value> {
    private class Node {
        Key key;
        Value value;
        Node next;
        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node first = null;
    private int size = 0;

    public void put(Key key, Value value) {
        first = put(first, key, value);
        size++;
    }

    private Node put(Node x, Key key, Value value) {
        if(x == null)   return new Node(key, value, next);
        if(key.equals(x.key)) {
            x.value = value;
            return x;
        }
        return put(x.next, key, value);
    }

    public Value get(Key key) {
        for(Node x = first; x != null; x = x.next) {
            if(key.equals(x.key))   return x.value;
        }
        return null;
    }

    private Node delete(Node x, Key key) {
        if(x == null || x.next == null)   return null;
        if(key.equals(x.key)) {
            x = x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    public void delete(Key key) {
        first = delete(first, key);
    }


    
}
