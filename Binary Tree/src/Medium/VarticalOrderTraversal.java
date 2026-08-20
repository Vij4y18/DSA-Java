package Medium;

import Nodes.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class VarticalOrderTraversal {
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

        System.out.println(verticalTraversal(root));
    }

    static List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer, List<Integer>>> mpp = new TreeMap<>();
        List<List<Integer>> result = new ArrayList<>();

        traverse(root, 0, 0, mpp);

        for (TreeMap<Integer, List<Integer>> rows : mpp.values()) {
            List<Integer> col = new ArrayList<>();

            for (List<Integer> values : rows.values()) {
                Collections.sort(values);
                col.addAll(values);
            }

            result.add(col);
        }

        return result;
    }

    static void traverse (TreeNode root, int row, int col, TreeMap<Integer,TreeMap<Integer, List<Integer>>> mpp) {
        if (root == null) return;

        mpp.putIfAbsent(col, new TreeMap<>());
        TreeMap<Integer, List<Integer>> rows = mpp.get(col);

        rows.putIfAbsent(row, new ArrayList<>());
        rows.get(row).add(root.val);

        traverse(root.left, row+1, col-1, mpp);
        traverse(root.right, row+1, col+1, mpp);
    }
}
