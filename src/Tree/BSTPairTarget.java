package Tree;


import java.util.Objects;
import java.util.Stack;

/*
 * Given a Binary Search Tree and a target sum. Check whether there's a pair of Nodes in the BST with value summing up to the target sum.
 *
 * */
public class BSTPairTarget {

    public static void main(String[] args) {

        Node root = new Node(15);
        root.left = new Node(10);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right = new Node(20);
        root.right.right = new Node(25);
        root.right.left = new Node(16);

        System.out.println(isPairPresent(root, 28));

    }

    // root : the root Node of the given BST
    // target : the target sum
    public static int isPairPresent(Node root, int target) {
        // Write your code here

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        boolean flag1 = false, flag2 = false;

        int val1 = 0, val2 = 0;
        Node temp1 = root, temp2 = root;

        while (true) {
            while (flag1 == false) {
                if (temp1 != null) {
                    s1.push(temp1);
                    temp1 = temp1.left;
                } else {
                    if (s1.isEmpty() == true) {
                        flag1 = true;
                    } else {
                        Node curr = s1.pop();
                        val1 = curr.data;
                        temp1 = curr.right;
                        flag1 = true;
                    }
                }
            }

            while (flag2 == false) {
                if (temp2 != null) {
                    s2.push(temp2);
                    temp2 = temp2.right;
                } else {
                    if (s2.isEmpty() == true) {
                        flag2 = true;
                    } else {
                        Node curr = s2.pop();
                        val2 = curr.data;
                        temp2 = curr.left;
                        flag2 = true;
                    }
                }

            }

            if ((val1 + val2) == target && val1 != val2)
                return 1;

            else if ((val1 + val2) > target)
                flag2 = false;
            else if ((val1 + val2) < target)
                flag1 = false;

            if (val1 >= val2)
                return 0;
        }
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int d) {
            data = d;
            left = right = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return data == node.data &&
                    Objects.equals(left, node.left) &&
                    Objects.equals(right, node.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data, left, right);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }


}
