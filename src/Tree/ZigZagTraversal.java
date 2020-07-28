package Tree;

import java.util.*;

public class ZigZagTraversal {

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

        List<List<Integer>> result = zigZagV1(root);

        for (List<Integer> li : result) {
            for (Integer i : li) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        System.out.println("---------------- Efficient Solution-------------------");

        List<List<Integer>> resultEffective = zigZagV2(root);

        for (List<Integer> li : resultEffective) {
            for (Integer i : li) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    /*
     * Efficient solution as it'll process with 2 stacks and each element can process only 2 operation i.e. push and pop
     * */
    private static List<List<Integer>> zigZagV2(Node root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        Stack<Node> leftToRightStack = new Stack<>();
        Stack<Node> rightToLeftStack = new Stack<>();

        leftToRightStack.push(root);

        while (leftToRightStack.isEmpty() == false || rightToLeftStack.isEmpty() == false) {

            List<Integer> res = new ArrayList<>();

            while (leftToRightStack.isEmpty() == false) {


                Node curr = leftToRightStack.pop();

                res.add(curr.data);

                if (curr.left != null)
                    rightToLeftStack.push(curr.left);
                if (curr.right != null)
                    rightToLeftStack.push(curr.right);
            }

            if (res.isEmpty() == false)
                result.add(res);

            res = new ArrayList<>();

            while (rightToLeftStack.isEmpty() == false) {

                Node curr = rightToLeftStack.pop();

                res.add(curr.data);

                if (curr.right != null)
                    leftToRightStack.push(curr.right);
                if (curr.left != null)
                    leftToRightStack.push(curr.left);

            }
            if (res.isEmpty() == false)
                result.add(res);
        }

        return result;
    }

    /*
     *
     * Not so efficient as each element at worst case have to processed 4 times i.e enqueue, dequeue, push , pop. So, it's not efficient in space.
     *
     * */
    private static List<List<Integer>> zigZagV1(Node root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Stack<Integer> s = new Stack<>();
        boolean reverse = false;

        while (q.isEmpty() == false) {
            int size = q.size();
            List<Integer> res = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                Node curr = q.poll();

                if (reverse)
                    s.push(curr.data);
                else
                    res.add(curr.data);

                if (curr.left != null)
                    q.add(curr.left);

                if (curr.right != null)
                    q.add(curr.right);
            }

            while (s.isEmpty() == false) {
                res.add(s.pop());
            }
            reverse = !reverse;

            result.add(res);
        }

        return result;
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
