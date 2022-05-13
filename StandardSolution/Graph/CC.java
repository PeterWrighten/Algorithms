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

package Graph;

import Graph.api.Graph;
import java.lang.IllegalArgumentException;  


public class CC {
    private boolean[] marked;
    private int[] id;
    private int[] size;
    private int count;


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

    public int size(int v) {
        validateVertex(v);
        return size[id[v]];
    }

    public int id(int v) {
        validateVertex(v);
        return id[v];
    }

    public int count() {
        return count;
    }

    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v > V) {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
        }
    }

    public boolean connected(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return id[v] == id[w];
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        size[count]++;
        for(int w: G.adj(v)) {
           if(!marked[w]){
               dfs(G, w);
           }
        }
    }
}