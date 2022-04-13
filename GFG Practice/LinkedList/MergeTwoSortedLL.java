class Solution {
    public static Node mergeSortedLL(Node head1, Node head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;

        Node curr1 = head1;
        Node curr2 = head2;
        Node head3;
        if (curr1.data < curr2.data) {
            head3 = curr1;
            curr1 = curr1.next;
        } else {
            head3 = curr2;
            curr2 = curr2.next;
        }

        Node curr3 = head3;
        while (curr1 != null && curr2 != null) {
            if (curr1.data < curr2.data) {
                curr3.next = curr1;
                curr1 = curr1.next;
            } else {
                curr3.next = curr2;
                curr2 = curr2.next;
            }
            curr3 = curr3.next;
        }

        if (curr1 != null)
            curr3.next = curr1;
        if (curr2 != null)
            curr3.next = curr2;
        return head3;
    }

    public static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node node1 = new Node(5);
        Node node2 = new Node(10);
        Node node3 = new Node(15);
        Node node4 = new Node(40);
        Node head1 = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        Node node5 = new Node(2);
        Node node6 = new Node(3);
        Node node7 = new Node(20);
        Node head2 = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;
        printLinkedList(head1);
        printLinkedList(head2);
        Node head3 = mergeSortedLL(head1, head2);
        printLinkedList(head3);
    }
}

class Node {
    int data;
    Node next, random;

    Node(int mData) {
        data = mData;
        next = null;
        random = null;
    }
}