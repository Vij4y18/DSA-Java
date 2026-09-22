package Medium;

import Nodes.TreeNode;

public class KthSmallest {
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

        int k = 5;

        System.out.println(kthSmallest(root,k));
    }

    static int kthSmallest(TreeNode root, int k) {
        // findKthSmallest(root, k);
        return findKth(root,k);
    }

    static int count = 0;
    static int ans = 0;

    // Variation 1 O(N) and O(H)
    static void findKthSmallest(TreeNode root, int k) {
        if (root == null) return;


        findKthSmallest(root.left, k);

        count++;

        if (count == k) {
            ans = root.val;
            return;
        }

        findKthSmallest(root.right, k);
    }

    // variation 2 time: O(N) and space: O(H)
    static int findKth (TreeNode root, int k) {
        if (root == null) return -1;

        //left
        if (root.left != null) {
            int leftSum = findKth(root.left, k);

            if (leftSum != -1) return leftSum;
        }

        //root
        count += 1;
        if (count == k) return root.val;

        // right
        return findKth(root.right, k);
    }
}
