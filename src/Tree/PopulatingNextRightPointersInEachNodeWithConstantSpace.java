package Tree;

/*
*
* Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.



Follow up:

You may only use constant extra space.
Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.


Example 1:



Input: root = [1,2,3,4,5,null,7]
Output: [1,#,2,3,#,4,5,7,#]
Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.


Constraints:

The number of nodes in the given tree is less than 6000.
-100 <= node.val <= 100
*
* */

public class PopulatingNextRightPointersInEachNodeWithConstantSpace {

    public static void main(String[] args) {

        Node root = new Node(10);
//        root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.right.right = new Node(90);


        root = connect(root);


        // Let us check the values of nextRight pointers
        int a = root.next != null ?
                root.next.val : -1;
        int b = root.left.next != null ?
                root.left.next.val : -1;
        int c = root.right.next != null ?
                root.right.next.val : -1;
        int d = root.left.left.next != null ?
                root.left.left.next.val : -1;
        int e = root.right.right.next != null ?
                root.right.right.next.val : -1;

        // Now lets print the values
        System.out.println("Following are populated nextRight pointers in "
                + " the tree(-1 is printed if there is no nextRight)");
        System.out.println("nextRight of " + root.val + " is " + a);
        System.out.println("nextRight of " + root.left.val
                + " is " + b);
        System.out.println("nextRight of " + root.right.val +
                " is " + c);
        System.out.println("nextRight of " + root.left.left.val +
                " is " + d);
        System.out.println("nextRight of " + root.right.right.val +
                " is " + e);


    }

    private static Node connect(Node root) {

        if (root == null) {
            return null;
        }

        root.next = null;

        while (root != null) {
            Node temp = root;

            while (temp != null) {
                if (temp.left != null) {
                    if (temp.right != null) {
                        temp.left.next = temp.right;
                    } else
                        temp.left.next = getRightNode(temp);
                }

                if (temp.right != null)
                    temp.right.next = getRightNode(temp);

                temp = temp.next;
            }

            if (root.left != null)
                root = root.left;
            else if (root.right != null)
                root = root.right;
            else
                root = getRightNode(root);
        }

        return root;
    }

    private static Node getRightNode(Node root) {

        Node temp = root.next;

        while (temp != null) {
            if (temp.left != null)
                return temp.left;
            if (temp.right != null)
                return temp.right;
            temp = temp.next;
        }

        return null;
    }

    static class Node {
        int val;
        Node left, right, next;

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
            this.next = null;
        }

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }

    }


}
