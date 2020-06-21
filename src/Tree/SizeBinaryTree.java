package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SizeBinaryTree {

    static class Node {
        int data;
        Node left, right = null;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

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

            System.out.println("Size of Binary Tree : " + treeSizeV1(root));
            System.out.println("Size of Binary Tree : " + treeSizeV2(root));
        }

        /*
         * This is recursion method of getting size i.e. depth-first manner
         * */
        private static int treeSizeV1(Node root) {

            if (root == null)
                return 0;
            else
                return 1 + treeSizeV1(root.left) + treeSizeV1(root.right);
        }


        /*
         * This is iterative method of getting size i.e. level-order manner
         * */
        private static int treeSizeV2(Node root) {

            if (root == null)
                return 0;

            Queue<Node> q = new LinkedList<>();
            q.add(root);

            int size = 0;

            while (q.isEmpty() == false) {
                Node curr = q.poll();

                if (curr != null)
                    size++;
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }


            return size;
        }
    }
}
