package Medium;
import Nodes.TreeNode;
import com.sun.source.tree.Tree;

import java.util.*;

class Pair {
    TreeNode node;
    int col;

    Pair (TreeNode node, int col) {
        this.node = node;
        this.col = col;
    }
}

public class TopView {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.right.left = new TreeNode(8);
        root.left.right.left.left = new TreeNode(9);
        root.left.right.left.left.left = new TreeNode(10);

        System.out.println(topView(root));
    }

    static List<Integer> topView (TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Map<Integer, Integer> mpp = new TreeMap<>();
        Queue<Pair> Q = new LinkedList<>();

        Q.offer(new Pair(root, 0));

        while (!Q.isEmpty()) {
            Pair curr = Q.poll();

            int col = curr.col;
            TreeNode node = curr.node;

            if (!mpp.containsKey(col)) {
                mpp.put(col, node.val);
            }

            if (node.left != null) Q.offer(new Pair(node.left, col-1));
            if (node.right != null) Q.offer(new Pair(node.right, col+1));
        }

        for (int nums : mpp.values()) {
            result.add(nums);
        }

        return result;
    }
}
