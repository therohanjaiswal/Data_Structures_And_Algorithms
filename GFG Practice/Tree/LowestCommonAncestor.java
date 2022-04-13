
// https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
import java.util.*;

class Solution {
    Node root;

    Solution() {
        root = null;
    }

    // TC: O(n), SC: O(1) and require 3 traversals
    Node lcaNaive(int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        if (findPath(root, path1, n1) == false || findPath(root, path2, n2) == false)
            return null;
        for (int i = 0; i < path1.size() - 1 && i < path2.size() - 1; ++i) {
            if (path1.get(i + 1) != path2.get(i + 1))
                return path1.get(i);
        }
        return null;
    }

    boolean findPath(Node root, ArrayList<Node> arr, int n1) {
        if (root == null)
            return false;
        arr.add(root);
        if (root.key == n1)
            return true;
        if (findPath(root.left, arr, n1) || findPath(root.right, arr, n1))
            return true;
        arr.remove(arr.size() - 1);
        return false;
    }

    // // TC: O(n), SC: O(1) and require 1 traversal
    Node lcaEfficient(Node root, int n1, int n2) {
        if (root == null)
            return null;
        if (root.key == n1 || root.key == n2)
            return root;
        Node left = lcaEfficient(root.left, n1, n2);
        Node right = lcaEfficient(root.right, n1, n2);
        if (left != null && right != null)
            return root;
        if (left != null)
            return left;
        return right;
    }

    void lca() {
        System.out.println(lcaNaive(40, 70).key);
        System.out.println(lcaEfficient(root, 40, 70).key);
    }

    public static void main(String[] args) {
        Solution tree = new Solution();
        tree.root = new Node(10);
        tree.root.left = new Node(20);
        tree.root.right = new Node(30);
        tree.root.left.left = new Node(40);
        tree.root.left.left.right = new Node(100);
        tree.root.left.right = new Node(50);
        tree.root.right.left = new Node(60);
        tree.root.right.right = new Node(70);
        tree.lca();
    }
}

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}
