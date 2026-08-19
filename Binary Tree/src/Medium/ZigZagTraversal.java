package Medium;
import Nodes.TreeNode;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class ZigZagTraversal {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(zigzagLevelOrder(root));
    }

    static List<List<Integer>> zigzagLevelOrder (TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> ans = new ArrayList<>();

            for (int i=0; i<size; i++) {
                TreeNode curr = q.poll();

                if (level % 2 != 0) { // Odd Level so add left to right
                    ans.add(curr.val);
                } else {
                    ans.add(0,curr.val); // Even level -> right to left
                }

                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }

            level++;
            result.add(ans);
        }
        return result;
    }
}
