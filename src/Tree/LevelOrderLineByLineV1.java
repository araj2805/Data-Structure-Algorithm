package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderLineByLineV1 {

    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(20);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right = new Node(30);
        root.right.right = new Node(60);
        root.right.right.right = new Node(80);
        root.right.right.left = new Node(70);

        levelOrderLineByLine(root);
    }

    private static void levelOrderLineByLine(Node root) {

        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (q.size() > 1) {
            Node curr = q.poll();

            if (curr == null) {
                q.add(null);
                System.out.println();
            } else {
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

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
