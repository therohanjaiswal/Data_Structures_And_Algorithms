
// https://www.youtube.com/watch?v=eTaWFhPXPz4
import java.util.*;

class Solution {

    // TC: O(V)
    public static int find(int v, int[] parent) {
        if (parent[v] == -1)
            return v;
        return find(parent[v], parent);
    }

    // TC: O(V)
    public static void union(int headOfSrc, int headOfDest, int[] parent) {
        headOfSrc = find(headOfSrc, parent);
        headOfDest = find(headOfDest, parent);
        parent[headOfSrc] = headOfDest;
    }

    // TC: O(E * V), works only for undirected graph
    public static boolean isCyclicUnionFind(int V, ArrayList<Edge> edges) {
        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        for (Edge e : edges) {
            int headOfSrc = find(e.src, parent);
            int headOfDest = find(e.dest, parent);
            if (headOfDest == headOfSrc)
                return true;
            union(headOfSrc, headOfDest, parent);
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
        if (isCyclicUnionFind(V, graph))
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