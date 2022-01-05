package api.WE;

/****************************************************************
 * 
 *     public class DirectedEdge(int, int, double):
 *          private final int v,w;
 *          private final double weight;
 *          int from();
 *          int to();
 *          double weight();
 *          String toString();
 * 
 ****************************************************************/



public class DirectedEdge {
    private final int v, w;
    private final double weight;

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    public double weight() {
        return weight;
    }
    
}
