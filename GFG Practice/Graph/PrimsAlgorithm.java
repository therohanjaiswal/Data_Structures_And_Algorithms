
// https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/
import java.util.*;

// graph should be weighted connected and undirected
// can't find mst for disconnected or directed graph
class Prims {
    static class Edge {
        int v;
        int weight;

        Edge(int weight, int v) {
            this.weight = weight;
            this.v = v;
        }
    }

    public static class Graph {
        int size;
        ArrayList<ArrayList<Edge>> list;

        Graph(int n) {
            this.size = n;
            list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                ArrayList<Edge> l = new ArrayList<>();
                list.add(l);
            }
        }

        void addEdge(int u, int v, int weight) {
            list.get(u).add(new Edge(weight, v));
            list.get(v).add(new Edge(weight, u));
        }

        void addEdgeDirected(int u, int v, int weight) {
            list.get(u).add(new Edge(weight, v));
        }

        void print() {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(i + "->");
                for (Edge e : list.get(i)) {
                    System.out.print(e.v + "," + e.weight + " ->");
                }
                System.out.println();
            }
        }

        ArrayList<Edge> get(int u) {
            return list.get(u);
        }
    }

    // represents edge from pv to v of weight wt in priority queue
    static class Pair implements Comparable<Pair> {
        int v; // vertex
        int pv; // parent vertex
        int wt;

        Pair(int v, int pv, int wt) {
            this.v = v;
            this.pv = pv;
            this.wt = wt;
        }

        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the number of vertices in the graph: ");
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        System.out.println("Enter the number of Edges");
        int e = sc.nextInt();
        System.out.println("Enter u v  and weight for the edges");
        Graph graph = new Graph(V);
        for (int i = 1; i <= e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int weight = sc.nextInt();
            graph.addEdge(u, v, weight);
        }

        System.out.println(findMSTNaive(V, graph));
        System.out.println(findMSTValueEfficient(V, graph));
    }

    // TC: O(V^2), SC: O(V)
    static int findMSTNaive(int V, Graph graph) {
        int result = 0;
        int[] parent = new int[V];
        int[] key = new int[V];
        boolean[] mSet = new boolean[V];

        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;

        int minKeyVertex = -1;
        for (int count = 0; count < V; ++count) {
            minKeyVertex = getMinKey(V, key, mSet);
            mSet[minKeyVertex] = true;
            result += key[minKeyVertex];
            for (Edge e : graph.get(minKeyVertex)) {
                if (!mSet[e.v] && e.weight < key[e.v]) {
                    key[e.v] = e.weight;
                    parent[e.v] = minKeyVertex;
                }
            }
        }

        return result;
    }

    static int getMinKey(int V, int[] key, boolean[] mSet) {
        int minKeyIndex = -1, minKeyValue = Integer.MAX_VALUE;
        for (int i = 0; i < V; ++i) {
            if (!mSet[i] && key[i] < minKeyValue) {
                minKeyValue = key[i];
                minKeyIndex = i;
            }
        }
        return minKeyIndex;
    }

    // TC: O(ElogV), SC: O(V + E), pq is maintained for every edge
    static int findMSTValueEfficient(int V, Graph graph) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, -1, 0));
        boolean[] visited = new boolean[graph.size];

        int totalMSTweight = 0;
        while (!pq.isEmpty()) {
            Pair rm = pq.remove();

            if (visited[rm.v])
                continue;

            visited[rm.v] = true;
            totalMSTweight += rm.wt;

            if (rm.pv != -1)
                System.out.println("[" + rm.v + "-" + rm.pv + " @ " + rm.wt + "]");

            for (Edge e : graph.get(rm.v)) {
                if (visited[e.v] == false)
                    pq.add(new Pair(e.v, rm.v, e.weight));
            }
        }

        return totalMSTweight;
    }
}