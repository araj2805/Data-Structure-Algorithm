package Tree;

public class SymetricOrMirrorTree {

    public static void main(String[] args) {

        Node root = new Node(5);
        root.left = new Node(1);
        root.left.left = new Node(2);
        root.right = new Node(1);
        root.right.right = new Node(2);

        System.out.println(isSymmetric(root));
    }

    private static boolean isSymmetric(Node root) {

        if (root == null)
            return true;

        return isMirror(root, root);
    }

    private static boolean isMirror(Node root1, Node root2) {

        if (root1 == null && root2 == null)
            return true;


        return root1.data == root2.data && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

}
