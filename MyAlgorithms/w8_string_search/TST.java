public class TST <Value>{
    private Node root;

    private class Node {
        private Value val;
        private char c;
        private Node left, mid, right;
        public Node(char c, Value val) {
            this.val = val;
            this.c = c;
        }
    }

    private Node put(Node x, String key, Value val, int d) {
        char c = key.charAt(d);
        if( x == null ) return new Node(c, null);
        if(d == key.length() - 1) {
            x.val = val;
            return x;
        }
        if(c > x.c) x.right = put(x.right, key, val, d);
        else if(c < x.c) x.left = put(x.left, key, val, d);
        else  x.mid = put(x.mid, key, val, d+1);
        return x;
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }
    
}
