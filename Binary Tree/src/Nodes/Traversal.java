package Nodes;

import java.util.List;

// preorder Traversal

public class Traversal {
    public void preorder(TreeNode root, List<Integer> result) {
        if (root == null) return;

        // System.out.print(root.val + " ");
        result.add(root.val);

        preorder(root.left, result);
        preorder(root.right, result);
    }
}
