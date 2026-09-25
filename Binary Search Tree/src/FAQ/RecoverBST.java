package FAQ;

import Nodes.TreeNode;

public class RecoverBST {
    static TreeNode first;
    static TreeNode mid;
    static TreeNode last;
    static TreeNode prev;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        root.right.left = new TreeNode(2);

        recoverTree(root);
        System.out.println(root.val);
    }

    static void recoverTree(TreeNode root) {
        first = mid = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);

        inorder(root);

        if (last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else {
            int temp = first.val;
            first.val = mid.val;
            mid.val = temp;
        }
    }

    static void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        if (prev != null && (prev.val > root.val)) {
            if (first == null) {
                first = prev;
                mid = root;
            } else {
                last = root;
            }
        }
        prev = root;

        inorder(root.right);
    }
}
