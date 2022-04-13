
// https://www.youtube.com/watch?v=kaBX2s3pYO4
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

    public static void addEdge(ArrayList<ArrayList<Integer>> g, int i, int j) {
        g.get(i).add(j);
        g.get(j).add(i);
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph = new ArrayList<>(V);
        graph.add(new Edge(0, 1));
        graph.add(new Edge(0, 2));
        graph.add(new Edge(1, 2));
        graph.add(new Edge(2, 3));
        graph.add(new Edge(1, 3));
        if (isCyclicPathCompression(V, graph))
            System.out.print("Cycle exists");
        else
            System.out.print("Cycle doesn't exists");
    }
}

class Edge {
    int src, dest;

    public Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
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