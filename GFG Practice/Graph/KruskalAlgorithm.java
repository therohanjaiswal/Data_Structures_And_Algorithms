
// https://www.youtube.com/watch?v=Ub-fJ-KoBQM
import java.util.*;

class Solution {

    static ArrayList<Subset> set = new ArrayList<>();

    // TC: O(logV)
    public static int find(int v) {
        if (set.get(v).parent == -1)
            return v;

        return set.get(v).parent = find(set.get(v).parent); // path compression
    }

    // TC: O(logV)
    public static void union(int headOfSrc, int headOfDest) {
        // case 1: if both have different rank
        if (set.get(headOfSrc).rank > set.get(headOfDest).rank) // src has higher rank
            set.get(headOfDest).parent = headOfSrc;
        else if (set.get(headOfSrc).rank < set.get(headOfDest).rank) // dest has higher rank
            set.get(headOfSrc).parent = headOfDest;
        else {
            // case 2: if both have same rank, then anyone can be made as parent
            set.get(headOfSrc).parent = headOfDest;
            set.get(headOfDest).rank += 1; // increment rank of parent
        }
    }

    // TC: O(E * logV), works only for undirected graph
    public static boolean isCyclicPathCompression(int V, ArrayList<Edge> edges) {
        for (int i = 0; i < V; ++i)
            set.add(new Subset(-1, 0));

        for (Edge e : edges) {
            int headOfSrc = find(e.src); // finds absolute parent of src
            int headOfDest = find(e.dest); // finds absolute parent of dest

            if (headOfDest == headOfSrc)
                return true;

            union(headOfSrc, headOfDest);
        }
        return false;
    }

    public static ArrayList<Edge> krushkal(int V, int E, ArrayList<Edge> edges) {
        ArrayList<Edge> mst = new ArrayList<>();

        Collections.sort(edges, new Comparator<Edge>() {
            public int compare(Edge e1, Edge e2) {
                return e1.weight - e2.weight;
            }
        });

        for (int i = 0; i < V; ++i)
            set.add(new Subset(-1, 0));

        // j < E checks whether it is even possible to form MST or not
        // i.e., it may happen we run out of edges and MST is not possible
        int i = 0, j = 0;
        while (i < V - 1 && j < E) {
            int fromP = find(edges.get(j).src);
            int toP = find(edges.get(j).dest);

            if (fromP == toP) {
                ++j;
                continue;
            }

            union(fromP, toP);
            mst.add(edges.get(j));
            ++i;
        }

        if (i < V - 1)
            return null;
        return mst;
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> g, int i, int j) {
        g.get(i).add(j);
        g.get(j).add(i);
    }

    public static void main(String[] args) {
        int V = 4;
        int E = 5;

        ArrayList<Edge> graph = new ArrayList<>(V);
        graph.add(new Edge(0, 1, 10));
        graph.add(new Edge(0, 2, 6));
        graph.add(new Edge(0, 3, 5));
        graph.add(new Edge(1, 3, 15));
        graph.add(new Edge(2, 3, 4));

        ArrayList<Edge> mst = krushkal(V, E, graph);
        if (mst.isEmpty()) {
            System.out.println("MST not possible");
            return;
        }

        int mstWeight = 0;
        for (Edge e : mst) {
            System.out.println(e.src + " -> " + e.dest + " , " + e.weight);
            mstWeight += e.weight;
        }
        System.out.println("Weight of MST: " + mstWeight);
    }
}

class Edge {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class Subset {
    int parent;
    int rank;

    public Subset(int parent, int rank) {
        this.parent = parent;
        this.rank = rank;
    }
}