package Hard;
import java.util.*;
import Nodes.TreeNode;

public class AllNodesDistanceK {
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        // Constructing tree:
        //
        //          3
        //        /   \
        //       5     1
        //      / \   / \
        //     6   2 0   8
        //        / \
        //       7   4

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode target = root.left; // node 5
        int k = 2;

        System.out.println(result);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        findParent(root, parent);
        searchNodes(target, visited, parent, k);

        return result;
    }

    public void searchNodes (TreeNode root, Set<Integer> visited, Map<TreeNode, TreeNode> parent, int k) {
        if (root == null || visited.contains(root.val) || k < 0) return;

        if (k == 0) {
            result.add(root.val);
            return;
        }

        visited.add(root.val);

        searchNodes(parent.get(root), visited, parent, k-1);
        searchNodes(root.left, visited, parent, k-1);
        searchNodes(root.right, visited, parent, k-1);
    }

    public void findParent (TreeNode root, Map<TreeNode, TreeNode> parent) {
        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(root);

        parent.put(root, null);

        while (!Q.isEmpty()) {
            TreeNode curr = Q.poll();

            if (curr.left != null) {
                parent.put(curr.left, curr);
                Q.offer(curr.left);
            }

            if (curr.right != null) {
                parent.put(curr.right, curr);
                Q.offer(curr.right);
            }
        }
    }
}
