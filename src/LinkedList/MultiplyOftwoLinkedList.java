package LinkedList;

public class MultiplyOftwoLinkedList {
    public static void main(String[] args) {
        Node l1 = new Node(1);
        l1.next = new Node(0);
        l1.next.next = new Node(0);

        Node l2 = new Node(1);
        l2.next = new Node(0);

        System.out.println(multiplyTwoLists(l1, l2));
    }

    private static long multiplyTwoLists(Node l1, Node l2) {

        long mod = (long) (1e9 + 7);


        long n1 = 0, n2 = 0;

        Node temp1 = l1, temp2 = l2;

        while (temp1 != null) {
            n1 = (10 * n1 + temp1.data) % mod;
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            n2 = (10 * n2 + temp2.data) % mod;
            temp2 = temp2.next;
        }

        Long res = (n1 * n2) % mod;

        return res;
    }

    static class Node {
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
