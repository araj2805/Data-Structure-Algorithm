package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstTrasversal {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(15);
        root.left.left = new Node(30);
        root.right = new Node(20);
        root.right.left = new Node(40);
        root.right.left.left = new Node(60);
        root.right.left.right = new Node(70);
        root.right.right = new Node(50);

        levelTraversal(root);
    }

    private static void levelTraversal(Node root) {
        if (root == null) return;

        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        while (nodeQueue.isEmpty() == false) {
            Node curr = nodeQueue.poll();
            System.out.print(curr.data + " ");

            if (curr.left != null)
                nodeQueue.add(curr.left);
            if (curr.right != null)
                nodeQueue.add(curr.right);

        }

    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
