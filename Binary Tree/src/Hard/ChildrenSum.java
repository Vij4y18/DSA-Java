package Hard;
import Nodes.TreeNode;

public class ChildrenSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(6);
        root.right = new TreeNode(4);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(3);

        System.out.println(checkChildrenSum(root));
    }

    static boolean checkChildrenSum(TreeNode root) {
        // Your code goes here
        if (root == null) return true;

        if (root.left == null && root.right == null) return true;

        int left = root.left != null ? root.left.val : 0;
        int right = root.right != null ? root.right.val : 0;

        if (root.val != left + right) return false;

        return checkChildrenSum(root.left) && checkChildrenSum(root.right);
    }
}
