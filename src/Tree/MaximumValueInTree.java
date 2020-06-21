package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumValueInTree {
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

            System.out.println("Maximum Value in Binary Tree : " + getMaxValv1(root));
            System.out.println("Maximum Value in Binary Tree : " + getMaxValv2(root));


        }


        /*
         * This is recursion method of getting size i.e. depth-first manner
         * */
        private static int getMaxValv1(Node root) {

            if (root == null)
                return Integer.MIN_VALUE;
            else
                return Math.max(root.data, Math.max(getMaxValv1(root.left), getMaxValv1(root.right)));
        }

        /*
         * This is iterative method of getting size i.e. level-order manner
         * */
        private static int getMaxValv2(Node root) {

            if (root == null)
                return Integer.MIN_VALUE;

            Queue<Node> q = new LinkedList<>();
            q.add(root);

            int maxVal = Integer.MIN_VALUE;

            while (q.isEmpty() == false) {
                Node curr = q.poll();

                maxVal = Math.max(maxVal, curr.data);

                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
            return maxVal;
        }
    }
}
