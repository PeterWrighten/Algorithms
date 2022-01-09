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

    private Node get(Node x, String key, int d) {
        if(x == null)   return null;
        char c = key.charAt(d);
        if(d == key.length() - 1)  return x;
        if(c < x.c) return get(x.left, key, d);
        else if(c > x.c) return get(x.right, key, d);
        else return get(x.mid, key, d+1);
    }

    public Value get(String key) {
        Node x = get(root, key, 0);
        if(x == null) return null;
        return x.val;
    }

    private Node delete(Node x, String key, int d) {
        if(x == null)   return null;
        if(d == key.length() - 1) {
            x.val = null;
        }
        else {
            char c = key.charAt(d);
            if(c > x.c) x.right = delete(x.right, key, d);
            else if(c < x.c) x.left = delete(x.left, key, d);
            else x.mid = delete(x.mid, key, d+1);
        }
        if(x.val != null)   return x;

        if( x.left != null 
            || x.right != null
            || x.mid != null ) {
                return x;
            }

        return null;
    }

    public void delete(String key) {
        root = delete(root, key, 0);
    }
    
}
