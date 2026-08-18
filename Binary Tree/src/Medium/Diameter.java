package Medium;

import Nodes.TreeNode;

/*
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.
 */

public class Diameter {
    static int ans = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);

        root.right.left.left = new TreeNode(5);
        root.right.left.left.left = new TreeNode(9);

        root.right.right.right = new TreeNode(7);
        root.right.right.right.right = new TreeNode(8);

        System.out.println(diameterOfBinaryTree(root));
    }

    static int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return ans;
    }

    static int height (TreeNode root) {
        if (root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        ans = Math.max(ans, lh+rh);

        return Math.max(lh,rh)+1;
    }
}
