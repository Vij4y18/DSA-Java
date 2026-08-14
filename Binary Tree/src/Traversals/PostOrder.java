package Traversals;

import Nodes.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PostOrder {
    public static void main(String[] args) {
        // Creating a Binary Tree
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

        System.out.println(postorderTraversal(root));
        System.out.println();
        // System.out.println(inorderIterative(root));
    }

    static List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    static void postorder (TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }

        postorder(root.left, result);  // traverse left
        postorder(root.right, result); // traverse right

        result.add(root.val); // print root
    }
}
