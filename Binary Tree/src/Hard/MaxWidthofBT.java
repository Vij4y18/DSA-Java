package Hard;

import Nodes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    TreeNode node;
    int index;

    Pair (TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}

public class MaxWidthofBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        root.left.left.left = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        System.out.println(widthOfBinaryTree(root));
    }

    static int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> Q = new LinkedList<>();
        int ans = Integer.MIN_VALUE;

        Q.offer(new Pair(root, 0));

        while (!Q.isEmpty()) {
            int size = Q.size();
            int firstIndex = 0;
            int lastIndex = 0;

            for (int i=0; i<size; i++) {
                Pair curr = Q.poll();
                TreeNode currNode = curr.node;
                int index = curr.index;

                if (i == 0) firstIndex = index;
                if (i == size-1) lastIndex = index;
                index -= 1;  // preventing overflow

                if (currNode.left != null) Q.offer(new Pair(currNode.left, 2*index+1));
                if (currNode.right != null) Q.offer(new Pair(currNode.right, 2*index+2));
            }

            ans = Math.max(ans, lastIndex-firstIndex + 1);
        }

        return ans;
    }
}
