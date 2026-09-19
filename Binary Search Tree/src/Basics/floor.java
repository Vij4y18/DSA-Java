package Basics;

import Nodes.TreeNode;

public class floor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);

        int target = 7;

        System.out.println(findFloor(root, target));

    }

    static int findFloor (TreeNode root, int target) {
        int ans = -1;

        while (root != null) {
            if (root.val <= target) {
                ans = root.val;
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return ans;
    }
}
