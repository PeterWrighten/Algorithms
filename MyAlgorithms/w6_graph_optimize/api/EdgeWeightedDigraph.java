package api;

import api.Bag;
import api.DirectedEdge;
/**************************************************************************
 * 
 *     public class EdgeWeightedDigraph:
 *          private final int V;
 *          private final Bag<DirectedEdge>[] adj;
 *          public void addEdge(DirectedEdge e);
 *          public Iterable<DirectedEdge> adj(int v);
 * 
 **************************************************************************/


public class EdgeWeightedDigraph {
    private final int V;
    private final Bag<DirectedEdge>[] adj;
    @SuppressWarnings("unchecked")
    public EdgeWeightedDigraph(int V) {
        this.V = V;
        adj = (Bag<DirectedEdge>[]) new Bag[V];
        for(int v = 0; v < V; v++) {
            adj[v] = new Bag<DirectedEdge>();
        }
    }

    public void addEdge(DirectedEdge e) {
        int v = e.from();
        adj[v].add(e);
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }
    
}
