
/**********************************************************************
 * 
 *    # Library: java.util.HashMap; java.util.IdentityHashMap;
 *               C++: std::unordered_map;
 * 
 *    public class SeperateChainingHashST<Key, Value>:
 *          private int M;
 *          private static class Node(Object, Object, Node) {
 *                private Object key;
 *                private Object value;
 *                private Node next;
 *          }
 *          
 *          public void put(Key, Value);
 *          public Value get(Key);
 *          public void delete(Key);
 * 
 **********************************************************************/

import java.util.Scanner;


public class SeperateChainingHT<Key, Value> {
    private int M = 97;
    private Node[] st = new Node[M];
    

    private static class Node {
        private Object key; /* static class should include static type. */
        private Object value;
        private Node next;
        public Node(Object key, Object value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;

        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private Node search(Key key) {
        int i = hash(key);
        for(Node x = st[i]; x != null; x = x.next) 
            if(key.equals(x.key)) return x;
        return null;

    }

    @SuppressWarnings("unchecked")
    public Value get(Key key) {
        Node tmp = search(key);
        if(tmp == null) return null;
        return (Value)tmp.value;
        
    }

    public void put(Key key, Value value) {
        int i = hash(key);
        for(Node x = st[i]; x != null; x = x.next){ 
            if(key.equals(x.key)) {
                x.value = value;
                return;
            }      
        }  
        st[i] =  new Node(key, value, st[i]);
        
    }

    private Node delete(Node x, Key key) {
        if(x == null || x.next == null) return null;
        if(key.equals(x.key)) {
            x = x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }
    @SuppressWarnings("unchecked")
    public Value delete(Key key) {
        int i = hash(key);
        st[i] = delete(st[i], key);
        for(Node x = st[i]; x != null; x = x.next) {
            if(key.equals(x.key))
                return (Value)x.value;
        }
        return null;

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SeperateChainingHT<String, String> ht = new SeperateChainingHT<String, String>();
        while(true) {
            System.out.println("0. Exit");
            System.out.println("1. Get");
            System.out.println("2. Put");
            System.out.println("3. Delete");
            System.out.println("-------------------------------------------------");
            int i = input.nextInt();
            switch(i) {
                case 0:
                    input.close();
                    System.exit(0);
                case 1:
                    System.out.println("Query Key>> ");
                    String tmp = input.next();
                    String result = ht.get(tmp);
                    if(result == null) {
                        System.out.println("No such key!");
                        break;
                    }
                    System.out.println("Value: " + result);
                    break;
                case 2:
                    System.out.println("Key>> ");
                    String k = input.next();
                    System.out.println("Value>> ");
                    String v = input.next();
                    ht.put(k, v);
                    break;
                case 3:
                    System.out.println("Key>> ");
                    String x = input.next();
                    String del = ht.delete(x);
                    if(del == null) {
                        System.out.println("Key doesnot exist!");
                        break;
                    }
                    System.out.println("Delete Successfully! Value: " + del);
                    break;
                default:
                    break;
            }
        }
    }

}
