package Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FindSumInTwoBST {

    public static void main(String[] args) {

    }

    public static boolean twoSumBST(Node root1, Node root2, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        inorder(root1, map, target);

        Stack<Node> stack = new Stack<>();

        while (stack.isEmpty() == false || root2 != null) {

            while (root2 != null) {
                stack.push(root2.left);
                root2 = root2.left;
            }

            root2 = stack.pop();

            if (map.containsKey(root2.val))
                return true;

            root2 = root2.right;
        }

        return false;
    }

    private static void inorder(Node root, Map<Integer, Integer> map, int target) {

        if (root == null)
            return;

        inorder(root.left, map, target);
        map.put(target - root.val, null);
        inorder(root.right, map, target);

    }

    class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            left = null;
            right = null;
        }

        public Node() {
        }
    }
}
