package Tree;

public class BalancedTree {

    public static void main(String[] args) {


        /*
         *           30
         *         /     \
         *       40      80
         *      /  \     /
         *     50  70   5
         *        /  \
         *       20  10
         *
         * */

        Node root = new Node(30);
        root.left = new Node(40);
        root.left.left = new Node(50);
        root.left.right = new Node(70);
        root.left.right.left = new Node(20);
        root.left.right.right = new Node(10);
        root.right = new Node(80);
        root.right.left = new Node(5);

        System.out.print(isBalance(root));
    }

    private static int isBalance(Node root) {

        if (root == null)
            return 0;

        int leftHeight = isBalance(root.left);
        if (leftHeight == -1)
            return -1;

        int rightHeight = isBalance(root.right);
        if (rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        else
            return Math.max(leftHeight, rightHeight) + 1;

    }

    static class Node {
        int data;
        Node left, right = null;

        public Node(int data) {
            this.data = data;
        }
    }

}
