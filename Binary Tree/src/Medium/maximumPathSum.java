package Medium;
import Nodes.TreeNode;

public class maximumPathSum {
    static int ans = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);

        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(20);

        root.left.left.left = new TreeNode(1);

        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(8);

        root.left.right.right.right = new TreeNode(9);

        root.right.right.left = new TreeNode(17);

        System.out.println(maxPathSum(root));
    }

    static int maxPathSum(TreeNode root) {
        maxContribution(root);
        return ans;
    }

    static int maxContribution (TreeNode root) {
        if (root == null) return 0;

        int leftContribution = Math.max(maxContribution(root.left),0);
        int rightContribution = Math.max(maxContribution(root.right),0);

        int currentContribution = root.val + leftContribution + rightContribution;
        ans = Math.max(ans, currentContribution);

        return root.val + Math.max(leftContribution, rightContribution);
    }
}
