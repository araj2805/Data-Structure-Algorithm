package Tree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * To Print Right View of Binary Tree we need to print the rightmost node at every level of the Binary Tree.
 * */
public class RightSideView {
    private static int maxlevel = 0;

    public static void main(String[] args) {

        /*
         *           10
         *         /   \
         *       50     60
         *             /  \
         *            70   20
         *              \
         *               8
         * */

        Node root = new Node(10);
        root.left = new Node(50);
        root.right = new Node(60);
        root.right.right = new Node(20);
        root.right.left = new Node(70);
        root.right.left.right = new Node(8);


        leftSideV1(root);
        System.out.println();
        leftSideV2(root);
    }

    private static void leftSideV1(Node root) {
        printLeftSideViewV1(root, 1);
    }

    /*
     * This is Depth first apporach i.e pre-order traversal (root,left,right)
     * */
    private static void printLeftSideViewV1(Node root, int level) {
        RightSideView rightSideView = new RightSideView();

        if (root == null) return;

        if (maxlevel < level) {
            System.out.print(root.data + " ");
            maxlevel = level;
        }

        // first recurce in right and then in left
        printLeftSideViewV1(root.right, level + 1);
        printLeftSideViewV1(root.left, level + 1);

    }

    private static void leftSideV2(Node root) {
        printLeftSideViewV2(root);
    }

    /*
     * This is level order traversal apporach and print when first element at each level is encounter
     * */
    private static void printLeftSideViewV2(Node root) {

        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (q.isEmpty() == false) {
            int count = q.size(); // Getting number of node at each level

            for (int i = 0; i < count; i++) {   // Adding child for each element in the current level in queue

                Node curr = q.poll();

                if (i == count - 1)  // Condition of printing first element from Right view side.
                    System.out.print(curr.data + " ");
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
        }
    }

    static class Node {

        int data;
        Node left;
        Node right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }
}
