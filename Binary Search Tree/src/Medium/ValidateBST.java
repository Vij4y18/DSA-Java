package Medium;

import Nodes.TreeNode;

public class ValidateBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println(isValidBST(root));
    }

    static boolean isValidBST(TreeNode root) {
        if (root.left == null && root.right == null) return true;
        return isBST(root, Long.MIN_VALUE,Long.MAX_VALUE);
    }

    static boolean isBST(TreeNode root, long low, long high) {
        if (root == null) return true;

        if (root.val <= low || root.val >= high) return false;

        boolean left = isBST(root.left,low, root.val);
        boolean right = isBST(root.right, root.val, high);

        return left && right;
    }
}
