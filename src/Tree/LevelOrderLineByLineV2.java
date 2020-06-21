package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderLineByLineV2 {
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

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (q.isEmpty() == false) {

            int count = q.size();

            for (int i = 0; i < count; i++) {
                Node curr = q.poll();
                System.out.print(curr.data + " ");
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }

            System.out.println();
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
