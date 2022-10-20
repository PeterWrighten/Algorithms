#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

class Graph {
        int Vertex;
        int E;
    public:
        vector<int> Adj;
        Graph(int v) {
            Adj.resize(v);
        }

        int V() const {
            return Vertex;
        }

        int& adj(int); 
};

int& Graph::adj(int v) {
    return Adj[v];
}

int main() {
    Graph g(3);
    g.adj(2) = 1;


    for(auto i: g.Adj) {
        cout << i << endl;
    }
    return 0;
}

