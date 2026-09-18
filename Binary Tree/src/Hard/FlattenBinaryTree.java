package Hard;

import Nodes.TreeNode;
import Nodes.Traversal;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(6);

        flatten(root);

        Traversal traverse = new Traversal(); // Printing output
        List<Integer> result = new ArrayList<>();
        traverse.preorder(root, result);
        System.out.println(result);
    }

    // Recursive approach O(N) + (h)
    static TreeNode prev = null;
    static void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;

        prev = root;
    }

    // Morris approach / predecessor approach O(N) + O(1)

    public void flatten_optimal(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left != null) {
                TreeNode predecessor = curr.left;

                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }

                predecessor.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}
