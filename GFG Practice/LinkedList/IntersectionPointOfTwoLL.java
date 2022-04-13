// https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/

public class Solution {
    public static int intersectPoint(Node head1, Node head2) {
        int count1 = 0, count2 = 0;
        Node temp1 = head1, temp2 = head2;
        while (temp1 != null) {
            ++count1;
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            ++count2;
            temp2 = temp2.next;
        }

        int diff = Math.abs(count1 - count2);
        temp1 = head1;
        temp2 = head2;
        if (count1 > count2) {
            while (diff-- != 0) {
                if (temp1 == null)
                    return -1;
                temp1 = temp1.next;
            }
        } else {
            while (diff-- != 0) {
                if (temp2 == null)
                    return -1;
                temp2 = temp2.next;
            }
        }

        while (temp1 != null && temp2 != null) {
            if (temp1 == temp2)
                return temp1.data;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return -1;
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
        Node node2 = new Node(8);
        Node node3 = new Node(7);
        Node node4 = new Node(10);
        Node node5 = new Node(12);
        Node node6 = new Node(15);
        Node node7 = new Node(9);
        Node head1 = node1;
        Node head2 = node7;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;
        node7.next = node4;
        int intersectingPoint = intersectPoint(head1, head2);
        System.out.println(intersectingPoint);
    }
}

class Node {
    int data;
    Node next;

    Node(int mData) {
        data = mData;
        next = null;
    }
}