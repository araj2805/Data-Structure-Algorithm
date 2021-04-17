package BasicDataStructure;

public class LL1 {
    int getNthNodeFromEnd(Node head, int n) {

        Node temp1 = head, temp2 = head;

        for (int i = 0; i < n; i++)
            temp2 = temp2.next;

        while (temp2 != null) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return temp1.val;
    }

    class Node {
        int val;
        Node next;

        Node(int x) {
            val = x;
            next = null;
        }
    }

}


