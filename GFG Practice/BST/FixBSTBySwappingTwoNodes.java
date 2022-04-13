// https://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/
class Solution {
    Node root;

    Solution() {
        root = null;
    }

    Node prev = null, first = null, second = null;

    // TC: O(n), SC: O(1)
    public Node fixBST(Node root) {
        if (root == null)
            return null;
        fixBSTUtils(root);
        // swapping data
        int temp = first.data;
        first.data = second.data;
        second.data = temp;
        return root;
    }

    public void fixBSTUtils(Node root) {
        if (root == null)
            return;
        fixBSTUtils(root.left);
        if (prev != null && root.data < prev.data) {
            if (first == null)
                first = prev;
            second = root;
        }
        prev = root;
        fixBSTUtils(root.right);
    }

    void checkForBST() {
        root = fixBST(root);
    }

    public static void main(String[] args) {
        Solution tree = new Solution();
        tree.root = new Node(100);
        tree.root.left = new Node(50);
        tree.root.right = new Node(150);
        tree.root.left.left = new Node(40);
        tree.root.left.left.right = new Node(45);
        tree.root.left.right = new Node(60);
        tree.root.right.left = new Node(120);
        tree.root.right.right = new Node(180);
        tree.checkForBST();
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