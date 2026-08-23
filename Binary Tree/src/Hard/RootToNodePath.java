package Hard;

import Nodes.TreeNode;
import java.util.List;
import java.util.ArrayList;

public class RootToNodePath {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        System.out.println(rootToNode(root, 7));
    }

    static List<Integer> rootToNode(TreeNode root, int node) {
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;

        searchNode(root, result, node);
        return result;
    }

    static boolean searchNode (TreeNode root, List<Integer> result, int node) {
        if (root == null) return false;

        result.add(root.val);
        if (root.val == node) return true;

        boolean left = searchNode(root.left, result, node);
        boolean right = searchNode(root.right, result, node);

        // backtrack
        if (left || right) {
            return true;
        }
        result.remove(result.size() - 1);

        return false;
    }
}
