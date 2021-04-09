package LinkedList;

public class RemoveEveryKthNode {
    public static Node delete(Node head, int k) {

        int count = 0;

        Node prev = head, temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;

            if (count == k - 1) {
                prev = temp.next.next;
                temp.next = prev;
                count = 0;
            }
        }
        return head;
    }

    class Node {
        int data;
        Node next;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}






