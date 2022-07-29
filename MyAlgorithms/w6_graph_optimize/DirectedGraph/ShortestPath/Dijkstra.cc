#include <vector>
#include <iostream>
#include <queue>
#include <climits>
using namespace std;

class Graph {
    private:
        int v, e = 0;
        struct edge {
            int v, w;
            edge(int v, int w) : v(v), w(w) {}
        };
        vector<vector<edge> > Adj;

    public:
        Graph(int v): v(v) {
            Adj.resize(v);
        }
        void add_edge(int, int, int);
        int V() {
            return v;
        }
        int E() {
            return e;
        }
        vector<edge> adj(int u) {
            return Adj[u];
        }
};

void Graph::add_edge(int u, int v, int w) {
    edge new_edge = edge(v, w);
    edge another = edge(u, w);
    Adj[u].push_back(new_edge);
    Adj[v].push_back(another);
    e += 1;
}


vector<int> dijkstra(Graph& g, int s) {
    vector<int> dis(g.V(), INT_MAX);
    vector<int> vis(g.V(), 0);
    dis[s] = 0;
    // pair<dis, ver>
    priority_queue<pair<int, int>, vector<pair<int, int> >, greater<pair<int, int> > > heap;
    heap.push(make_pair(0, s));
    while(!heap.empty()) {
        int u = heap.top().second;
        heap.pop();
        if(vis[u]) continue;
        vis[u] = 1;
        for(auto ed: g.adj(u)) {
            int v = ed.v;
            if(dis[v] > dis[u] + ed.w) {
                dis[v] = dis[u] + ed.w;
                heap.push(make_pair(dis[v], v));
            }  
        }
    }
    return dis;
}


int main() {
    int v;
    cout << "Input Vertex number: ";
    cin >> v;
    Graph g(v);
    cout << "1. add edge: u, v, w" << endl;
    int u, ver, w;
    while(1) {
        cin >> u >> ver >> w;
        if(u >= v || ver >= v) {
            break;
        }
        if(u < 0 || v < 0 || w < 0) {
            cerr << "illegal bound error!" << endl;
            exit(1);
        }
        g.add_edge(u, ver, w);
    }
    for(int i = 0; i < v; i++) {
        cout << "vertex " << i << ": " <<endl;
        for(auto ed: g.adj(i)) {
            cout << ed.v << endl;
        }
    }
    cout << "2. Dijkstra" << endl;
    vector<int> dis = dijkstra(g, 0);
    for(int i = 0; i < dis.size(); i++) {
        cout << "to vertex " << i << ": " << dis[i] << endl;
    }
    return 0;
}
