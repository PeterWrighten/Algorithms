/************************************************************
 * 
 *     public class Digraph:
 *          private final int V;
 *          private final Bag<Integer>[] adj;
 *          public void addEdge(int, int);
 *          public Iterable<Integer> adj(int);
 * 
 ************************************************************/

 package api;

 public class Digraph {
     private final int V;
     private final Bag<Integer>[] adj;

     @SuppressWarnings("unchecked")
     public Digraph(int V) {
         this.V = V;
         adj = (Bag<Integer>[]) new Bag[V];
         for(int v = 0; v < V; v++) {
             adj[v] = new Bag<Integer>();
         }
     }

     public void addEdge(int v, int w) {
         adj[v].add(w);
     }

     public Iterable<Integer> adj(int v) {
         return adj[v];
     }
 }