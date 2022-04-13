
// https://www.geeksforgeeks.org/zigzag-tree-traversal/
import java.util.*;

class Solution {
    // Root of Binary Tree
    Node root;

    Solution() {
        root = null;
    }

    // TC: O(n), SC: O(n+n) = O(n)
    ArrayList<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        int count = 0;
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        Stack<Node> temp;
        s1.push(root);

        while (!s1.empty()) {
            int size = s1.size();
            for (int i = 1; i <= size; i++) {
                Node curr = s1.pop();
                result.add(curr.data);
                if (count % 2 != 0) {
                    if (curr.right != null)
                        s2.push(curr.right);
                    if (curr.left != null)
                        s2.push(curr.left);
                } else {
                    if (curr.left != null)
                        s2.push(curr.left);
                    if (curr.right != null)
                        s2.push(curr.right);
                }
            }
            temp = s1;
            s1 = s2;
            s2 = temp;
            ++count;
        }
        return result;
    }

    void printZigZag() {
        ArrayList<Integer> list = zigZagTraversal(root);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        Solution tree = new Solution();
        tree.root = new Node(10);
        tree.root.left = new Node(20);
        tree.root.right = new Node(30);
        tree.root.left.left = new Node(40);
        tree.root.left.right = new Node(50);
        tree.root.right.left = new Node(60);
        tree.root.right.right = new Node(70);
        tree.printZigZag();
    }
}

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}
