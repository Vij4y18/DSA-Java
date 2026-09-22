package Medium;

import Nodes.TreeNode;

public class Lca {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);

        root.left = new TreeNode(4);
        root.right = new TreeNode(12);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);

        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);

        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(3);

        root.right.left.right = new TreeNode(11);

        TreeNode p = root.left.left;
        TreeNode q = root.left.left.right;

        System.out.println(lowestCommonAncestor(root,p,q).val);
    }

    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (root == p || root == q) return root;

            if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else {
                return root;
            }
        }
    }
}
