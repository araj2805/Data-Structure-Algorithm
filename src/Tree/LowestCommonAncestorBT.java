package Tree;

public class LowestCommonAncestorBT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)
            return null;

        if (root.val == p.val || root.val == q.val)
            return root;

        TreeNode leftLca = lowestCommonAncestor(root.left, p, q);

        TreeNode rightLca = lowestCommonAncestor(root.right, p, q);

        if (leftLca != null && rightLca != null)
            return root;

        if (leftLca != null)
            return leftLca;
        else
            return rightLca;

    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
