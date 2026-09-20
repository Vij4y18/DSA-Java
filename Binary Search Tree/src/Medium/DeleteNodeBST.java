package Medium;

import Nodes.TreeNode;

public class DeleteNodeBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(7);

        int key = 3;

        root = deleteNode(root, 3);
    }

    static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode predecessor = root.left;

                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }

                root.val = predecessor.val;
                root.left = deleteNode(root.left, predecessor.val);

                return root;
            }
        }
        return root;
    }
}
