package Tree;

public class ChildSumProperty {
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right = new Node(12);

        System.out.print(isChildSP(root));

    }

    private static boolean isChildSP(Node root) {

        // Base COndition 1
        if (root == null)
            return true;
        // Base Condition 2 -> leaf Node
        if (root.left == null && root.right == null)
            return true;

        int sum = 0;
        if (root.left != null)
            sum += root.left.data;
        if (root.right != null)
            sum += root.right.data;

        return (sum == (root.data) && isChildSP(root.left) && isChildSP(root.right));


    }

    static class Node {
        int data;
        Node left, right = null;

        public Node(int data) {
            this.data = data;
        }
    }
}
