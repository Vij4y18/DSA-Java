package FAQ;


import Nodes.TreeNode;

class Nodeval {
    int min;
    int max;
    int size;

    Nodeval (int min, int max, int size) {
        this.min = min;
        this.max = max;
        this.size = size;
    }
}

class Solution {
    public Nodeval BSThelper (TreeNode root) {
        if (root == null) {
            return new Nodeval(
                    Integer.MAX_VALUE,
                    Integer.MIN_VALUE,
                    0
            );
        }

        Nodeval left = BSThelper(root.left);
        Nodeval right = BSThelper(root.right);

        if (left.max < root.val && root.val < right.min) {
            return new Nodeval (
                    Math.min(root.val, left.min),
                    Math.max(root.val, right.max),
                    left.size + right.size + 1
            );
        }

        return new Nodeval (
                Integer.MIN_VALUE,
                Integer.MAX_VALUE,
                Math.max(left.size, right.size)
        );
    }

    public int largestBst(TreeNode root) {
        // code here
        return BSThelper(root).size;
    }
}

public class LargestBSTSubtree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);

        root.left = new TreeNode(6);
        root.right = new TreeNode(2);

        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(3);

        Solution obj = new Solution();
        int result = obj.largestBst(root);
        System.out.println(result);
    }
}
