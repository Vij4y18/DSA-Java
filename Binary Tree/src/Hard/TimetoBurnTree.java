package Hard;
import java.util.*;
import Nodes.TreeNode;

// Leetcode 2385 and this problem are same, code is copied from 2385 so variable name won't make any sense

public class TimetoBurnTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(5);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(6);

        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(2);

        int start = 3;

        System.out.println(timeToBurnTree(root, start));
    }

    static int timeToBurnTree(TreeNode root, int start) {
        //your code goes here
        if (root.left == null && root.right == null) return 0;

        Map<TreeNode, TreeNode> parent = new HashMap<>();


        TreeNode infectent = findParent(root, parent, start); // finding parent & infectant at the same time

        Set<TreeNode> visited = new HashSet<>();
        int time = infect(infectent,visited, parent);

        return time;
    }

    static TreeNode findParent (TreeNode root, Map<TreeNode, TreeNode> parent, int target) {
        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(root);

        TreeNode infectent = null;

        parent.put(root, null);

        while (!Q.isEmpty()) {
            TreeNode curr = Q.poll();

            if (curr.val == target) infectent = curr;

            if (curr.left != null) {
                parent.put(curr.left, curr);
                Q.offer(curr.left);
            }

            if (curr.right != null) {
                parent.put(curr.right, curr);
                Q.offer(curr.right);
            }
        }
        return infectent;
    }

    static int infect (TreeNode root, Set<TreeNode> visited, Map<TreeNode, TreeNode> parent) {
        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(root);
        int time = 0;

        while (!Q.isEmpty()) {
            int size = Q.size();

            for (int i=0; i<size; i++) {
                TreeNode curr = Q.poll();

                if (visited.contains(curr)) continue;
                visited.add(curr);

                if (curr.left != null && !visited.contains(curr.left)) Q.offer(curr.left);
                if (curr.right != null && !visited.contains(curr.right)) Q.offer(curr.right);
                if (parent.get(curr) != null && !visited.contains(parent.get(curr))) Q.offer(parent.get(curr));
            }

            if(!Q.isEmpty()) time++;
        }

        return time;
    }
}
