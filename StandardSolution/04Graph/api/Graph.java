package api;

import api.Bag;
import java.util.NoSuchElementException;

public class Graph {
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;
    private int E;
    private Bag<Integer>[] adj;
    
    @SuppressWarnings("unchecked")
    public Graph(int V) {
        if(V < 0)   throw new NoSuchElementException("Number of vertices must be non-negative.");
        this.V = V;
        this.E = 0;
        this.adj = (Bag<Integer>[]) new Bag[V];
        for(int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    public int V() { return V; }

    public int E() { return E; }

    private void validateVertex(int v) {
        if(v < 0 || v >= V) throw new IllegalArgException("vertex" + v + "is not between 0 and " + (V - 1));
    }

    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Bag<Integer>> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + "vertices, " + E + "edges." + NEWLINE);
        for(int v = 0; v < V; v++) {
            for(int w: adj[v]) {
                s.append(w + ", ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}
