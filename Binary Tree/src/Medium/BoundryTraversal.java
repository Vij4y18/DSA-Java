package Medium;

import java.util.ArrayList;
import java.util.List;
import Nodes.TreeNode;

public class BoundryTraversal {
    static void leftBoundry (TreeNode root, List<Integer> result) {
        if (root == null) return;

        if (root.left != null || root.right != null) {
            result.add(root.val);
        }

        if (root.left != null) {
            leftBoundry(root.left, result);
        } else {
            leftBoundry(root.right, result);
        }
    }

    static void leaves (TreeNode root, List<Integer> result) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            result.add(root.val);
            return;
        }
        leaves(root.left, result);
        leaves(root.right, result);
    }

    static void rightBoundry (TreeNode root, List<Integer> result) {
        if (root == null) return;

        if (root.right != null) {
            rightBoundry(root.right, result);
        } else {
            rightBoundry(root.left, result);
        }

        if (root.left != null || root.right != null) {
            result.add(root.val);
        }
    }

    static List<Integer> boundary(TreeNode root) {
        //your code goes here
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        if (root.left != null || root.right != null) result.add (root.val);

        leftBoundry(root.left, result);   // Getting leftBoundry
        leaves (root, result);            // Getting leaves
        rightBoundry(root.right, result); // Getting rightBoundry

        return result;
    }

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

        System.out.println(boundary(root));
    }
}
