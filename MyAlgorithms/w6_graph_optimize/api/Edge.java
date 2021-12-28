/****************************************************************
 * 
 *    public class Edge(int, int, double):
 *          private final int v, w;
 *          private final double weight;
 *          public int either();
 *          public int other(int);
 *          public int compareTo(Edge);
 * 
 ****************************************************************/


package api;

public class Edge implements Comparable<Edge> {
    private final int v, w;
    private final double weight;
    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either() {
        return v;
    }

    public int other(int v) {
        if(v == this.v) return this.w;
        else    return this. v;
    }

    @Override
    public int compareTo(Edge that) {
        if(this.weight > that.weight) return -1;
        else if(this.weight < that.weight) return 1;
        else return 0;
    }
}
