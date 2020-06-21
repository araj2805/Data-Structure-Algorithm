package Tree;

/*
 * Nodes at distance k from the root are basically the nodes at (k+1)th level of the Binary Tree.
 * */
public class KdistanceNode {
    public static void main(String[] args) {
        /*
         *                        10
         *                      /    \
         *                   30      40
         *                  /      /    \
         *               80      60     50
         *                 \
         *                  70
         * */

        Node root = new Node(10);
        root.left = new Node(30);
        root.left.left = new Node(80);
        root.left.left.right = new Node(70);
        root.right = new Node(40);
        root.right.right = new Node(50);
        root.right.left = new Node(60);

        printDistance(root, 2);
    }

    private static void printDistance(Node root, int k) {

        if (root == null) return;
        if (k == 0)
            System.out.print(root.data + " ");
        else {
            printDistance(root.left, k - 1);
            printDistance(root.right, k - 1);
        }
    }

    static class Node {
        int data;
        Node left, right = null;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
