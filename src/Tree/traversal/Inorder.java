package Tree.traversal;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Inorder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.right = new TreeNode(10);
        root.right.left.left = new TreeNode(11);
        root.right.right.left = new TreeNode(12);
        root.right.right.right = new TreeNode(13);


        List<Integer> inorder = getInorder(root);

        inorder.stream().forEach(i -> System.out.print(i + " "));

    }

    /**
     * InOrder : Left Root Right
     *
     * @param root
     * @return inorderList
     */
    private static List<Integer> getInorder(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if (root == null)
            return res;

        Stack<TreeNode> s = new Stack<>();

        TreeNode temp = root;

        while (temp != null || s.isEmpty() == false) {

            while (temp != null) {
                s.push(temp);
                temp = temp.left;
            }

            if (s.isEmpty())
                break;

            TreeNode curr = s.pop();
            res.add(curr.val);

            temp = curr.right;

        }

        return res;
    }

    private static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }


    }
}
