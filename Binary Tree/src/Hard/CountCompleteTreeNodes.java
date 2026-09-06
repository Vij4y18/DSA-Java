package Hard;

import Nodes.TreeNode;

public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);

        System.out.println(countNodes(root));
    }

    static int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = countLeft(root);
        int rightHeight = countRight(root);

        if (leftHeight == rightHeight) return (2<<leftHeight) - 1;
        else return 1 + countNodes(root.left) + countNodes(root.right);
    }

    static int countLeft (TreeNode root) {
        int count = 0;

        while (root.left != null) {
            count++;
            root = root.left;
        }

        return count;
    }

    static int countRight (TreeNode root) {
        int count = 0;

        while (root.right != null) {
            count++;
            root = root.right;
        }
        return count;
    }
}
