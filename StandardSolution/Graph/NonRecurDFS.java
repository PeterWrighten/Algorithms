/*  
 * 
 */

package Graph;

import Graph.api.Graph;
import java.util.Stack;
import java.util.Iterator;


 public class NonRecurDFS {
     private boolean[] marked;
     public NonRecurDFS(Graph  G, int s) {
        Iterator<Integer>[] adj = (Iterator<Integer>[]) new Iterator[G.V()];
        for(int v = 0; v < G.V(); v++) {
            adj[v] = G.adj(v).iterator();
        }
        Stack<Integer> stack = new Stack<Integer>();
        marked[s] = true;
        stack.push(s);
        while(!stack.isEmpty()) {
            int v = stack.peek();
            if(adj[v].hasNext()) {
                int w = adj[v].next();
                if(!marked[w]) {
                    marked[w] = true;
                    stack.push(w);
                }
            } else {
                stack.pop();
            }
        }

     }
 }