package Traversals;
import Nodes.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {

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

        System.out.println(preorderTraversal(root));
        System.out.println();
        System.out.println(preorderIterative(root));
    }

    static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    // Recursive Approach
    static void preorder(TreeNode root, List<Integer> result) {
        if (root == null) return;

        // System.out.print(root.val + " ");
        result.add(root.val);

        preorder(root.left, result);
        preorder(root.right, result);
    }

    static List<Integer> preorderIterative (TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            TreeNode curr = st.pop();

            result.add(curr.val);

            if (curr.right != null) {
                st.push(curr.right);
            }

            if (curr.left != null) {
                st.push(curr.left);
            }
        }

        return result;
    }
}
