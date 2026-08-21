package Medium;

import Nodes.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightView {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        System.out.println(rightSideViewIterative(root));
        System.out.println(rightSideViewRecursive(root));
    }

    static List<Integer> rightSideViewRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, 1, result);
        return result;
    }

    static int maxLvl = 0;

    static void rightView (TreeNode root, int currentLevel, List<Integer> result) {
        if (root == null) return;

        if (currentLevel > maxLvl) {
            maxLvl = currentLevel;
            result.add(root.val);
        }

        rightView(root.right, currentLevel+1, result);
        rightView(root.left, currentLevel+1, result);
    }

    static List<Integer> rightSideViewIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(root);


        while (!Q.isEmpty()) { // BFS
            int size = Q.size();
            int lastElement = 0;
            for (int i=0; i<size; i++) {
                TreeNode curr = Q.poll();

                if (curr.left != null) Q.offer(curr.left);
                if (curr.right != null) Q.offer(curr.right);
                lastElement = curr.val;
            }
            result.add(lastElement);
        }
        return result;
    }
}
