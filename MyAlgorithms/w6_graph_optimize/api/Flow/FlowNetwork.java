package api.Flow;

import api.Bag;
/************************************************************************************************
 * 
 *  public class FlowNetwork(int v):
 *      private final int V;
 *      private Bag<FlowEdge>[] adj;
 *      public void addEdge(FlowEdge e);
 *      Iterable<FlowEdge> adj(int v);
 * 
 ************************************************************************************************/
public class FlowNetwork {
    private final int V;
    private Bag<FlowEdge>[] adj;
    @SuppressWarnings("unchecked")
    public FlowNetwork(int V) {
        this.V = V;
        this.adj = (Bag<FlowEdge>[]) new Bag[V];
        for(int v = 0; v < V; v++) {
            adj[v] = new Bag<FlowEdge>();
        }
    }

    public void addEdge(FlowEdge e) {
        int v = e.from();
        int w = e.to();
        adj[v].add(e);
        adj[w].add(e);
    }

    public Iterable<FlowEdge> adj(int v) {
        return adj[v];
    }
}
