package Medium;

import Nodes.TreeNode;

public class SymmetricBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root));
    }

    static boolean isSymmetric(TreeNode root) {
        return findSymmetry(root.left, root.right);
    }

    static boolean findSymmetry(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p==q;
        }

        if (p.val != q.val) return false;

        return findSymmetry(p.left, q.right) && findSymmetry(p.right, q.left);
    }
}
