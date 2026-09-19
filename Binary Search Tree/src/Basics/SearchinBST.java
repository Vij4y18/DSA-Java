package Basics;

import Nodes.TreeNode;

public class SearchinBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int target = 2;

        TreeNode ans = searchBST(root, target);
        System.out.println(ans == null ? "null" : ans.val);
    }

    static TreeNode searchBST (TreeNode root, int val) {

        while (root != null) {
            if (root.val == val) {
                return root;
            } else if (root.val > val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return root;
    }
}
