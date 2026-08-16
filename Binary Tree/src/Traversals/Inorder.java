package Traversals;

import Nodes.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Inorder {
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

        System.out.println(inorderTraversal(root));
        System.out.println();
        System.out.println(inorderIterative(root));
    }

    static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    static void inorder(TreeNode root, List<Integer> result) {
        if (root == null) return;

        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    static List<Integer> inorderIterative (TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> result = new ArrayList<>();

        TreeNode curr = root;

        while (curr != null || !st.isEmpty()) {

            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }

            curr = st.pop();
            result.add(curr.val);

            curr = curr.right;
        }

        return result;
    }
}
