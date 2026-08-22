package Hard;

import Nodes.TreeNode;
import java.util.*;

public class RootToLeafPath {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);

        root.left = new TreeNode(8);
        root.right = new TreeNode(22);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);

        root.right.right = new TreeNode(25);

        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        System.out.println(allRootToLeaf(root));
    }

    static List<List<Integer>> ans = new ArrayList<>();

    static List<List<Integer>> allRootToLeaf(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) return ans;

        searchPath(root,result);

        return ans;
    }

    static void searchPath(TreeNode root, List<Integer> result) {
        if (root == null) return;

        result.add(root.val);

        if(root.left == null && root.right == null) {
            ans.add(new ArrayList(result));
        }

        searchPath(root.left, result);
        searchPath(root.right, result);

        result.remove(result.size()-1);
    }
}
