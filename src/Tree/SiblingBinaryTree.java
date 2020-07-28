/*
package Tree;
*/
/*
*   Given a binary tree and two nodes, the task is to check if the nodes are siblings of each other or not.
    Two nodes are said to be siblings if they are present at the same level, and their parents are same.
* *//*

public class SiblingBinaryTree {

    static class Node{
        int data;
        Node left,right =null;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.left.left.right = new Node(7);

        */
/*
 *  Here X and Y are two element to be searched.
 * *//*

        if(isSibling(root,5,6))
            System.out.print(true);
        else
            System.out.print(false);


    }

    */
/*
 * Two nodes to be sibling if there parent are same.
 * *//*

    private static boolean isSibling(Node root, int x, int y) {

        if (root == null)
            return false;

        if(root.left != null && root.right != null){
            int leftData = root.left.data;
            int rightData = root.right.data;

            if((leftData == x && rightData == y) || (leftData == y && rightData == x))
                return true;
        }

        if(root.left != null)
            isSibling(root.left,x,y);

        if (root.right != null)
            isSibling(root.right,x,y);

        return null;
    }
}
*/
