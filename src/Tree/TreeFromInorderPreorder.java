package Tree;

import java.util.HashMap;
import java.util.Map;

public class TreeFromInorderPreorder {

    static class Node {
        static int preOdrIndex = 0;
        int val;
        Node left, right = null;

        public Node(int val) {
            this.val = val;
        }

        public static void main(String[] args) {

            int[] preorder = {3, 9, 20, 15, 7};
            int[] inorder = {9, 3, 15, 20, 7};

            Node root = buildTree(preorder, inorder);
            inorderTraversal(root);

        }

        private static Node buildTree(int[] preorder, int[] inorder) {

            Map<Integer, Integer> inorderLookup = new HashMap<>();

            for (int i = 0; i < inorder.length; i++)
                inorderLookup.put(inorder[i], i);

            Node root = constructTree(preorder, inorder, inorderLookup, 0, preorder.length - 1);

            return root;
        }

        private static Node constructTree(int[] preorder, int[] inorder, Map<Integer, Integer> inorderLookup, int startIndex, int lastIndex) {

            if (startIndex > lastIndex)
                return null;

            Node root = new Node(preorder[preOdrIndex++]);

            int index = inorderLookup.get(root.val);

            root.left = constructTree(preorder, inorder, inorderLookup, startIndex, index - 1);
            root.right = constructTree(preorder, inorder, inorderLookup, index + 1, lastIndex);

            return root;
        }

        public static void inorderTraversal(Node root) {
            if (root != null) {
                inorderTraversal(root.left);
                System.out.print(root.val + " ");
                inorderTraversal(root.right);
            }
        }
    }
}
