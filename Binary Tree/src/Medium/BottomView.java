package Medium;
import Nodes.TreeNode;
import java.util.*;

public class BottomView {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);

        root.left = new TreeNode(8);
        root.right = new TreeNode(22);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);

        root.right.right = new TreeNode(25);

        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        System.out.println(bottomView(root));
    }

    static List<Integer> bottomView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Map<Integer, Integer> mpp = new TreeMap<>();
        Queue<Pair> Q = new LinkedList<>();

        Q.offer(new Pair(root, 0));

        while (!Q.isEmpty()) { // BFS
            Pair curr = Q.poll();

            int col = curr.col;
            TreeNode currNode = curr.node;

            mpp.put(col, currNode.val);

            if (currNode.left != null) Q.offer(new Pair(currNode.left, col-1));
            if (currNode.right != null) Q.offer(new Pair(currNode.right, col+1));
        }

        for (int val : mpp.values()) {
            result.add(val);
        }

        return result;
    }
}
