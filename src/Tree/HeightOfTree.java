package Tree;


/*
 * Height of Binary Tree is the number of nodes between the longest path from root to leaf node(including the root and leaf node).
 * */
public class HeightOfTree {
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

        System.out.println(getHeight(root));
    }

    private static int getHeight(Node root) {
        if (root == null)
            return 0;
        else
            return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
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
