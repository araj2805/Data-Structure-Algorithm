package Tree;

public class PopulateNextRightPointer {
    public static Node connect(Node root) {

        Node curr = root, prev = null, head = null;

        while (curr != null) {
            while (curr != null) {

                if (curr.left != null) {
                    if (prev != null)
                        prev.next = curr.left;
                    else
                        head = curr.left;

                    prev = curr.left;
                }

                if (curr.right != null) {
                    if (prev != null)
                        prev.next = curr.right;
                    else
                        head = curr.right;

                    prev = curr.right;
                }

                curr = curr.next;

            }


            curr = head;
            head = null;
            prev = null;
        }

        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

}
