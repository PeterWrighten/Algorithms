/************************************************************************************************
 *  
 * public class CC:
 *      private boolean[] marked; // marked[v] = has vertex v been marked?
 *      private int[] id; // id[v] = id of connected component containing v
 *      private int[] size; // size[id] = number of vertices in given component
 *      private int count; // number of connected components
 * 
 *      public CC(Graph G)
 *      private void dfs(Graph G, int v)
 *      public int size(int v)
 *      public int id(int v)
 *      public boolean connected(int v, int w)
 * 
 ************************************************************************************************/

import api.Graph;

import java.lang.IlegalArgumentException;

public class CC {
    // define data representation
    private boolean[] marked;
    private int[] id;
    private int[] size;
    private int count;


    // impl method
    public CC(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        size = new int[G.V()];
        for(int v = 0; v < G.V(); v++) {
            if(!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        size[count]++;
        for(int w: G.adj(v)) {
            if(!marked[w]) {
                dfs(G, v);
            }
        }

    }
}
