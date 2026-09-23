package Medium;

import Nodes.TreeNode;

import java.util.ArrayList;

public class Predecessor_successor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);

        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(20);

        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(8);

        root.left.right.right.right = new TreeNode(9);

        System.out.println(findPreSuc(root, 7));
    }

    static ArrayList<Integer> findPreSuc(TreeNode root, int key) {

        ArrayList<Integer> ans = new ArrayList<>();
        TreeNode ceil = findCeil(root,key);
        TreeNode floor = findFloor(root,key);
        ans.add(floor.val);
        ans.add(ceil.val);
        return ans;
    }

    static TreeNode findCeil (TreeNode root, int target) {
        TreeNode ans = new TreeNode(-1);

        while (root != null) {
            if (root.val > target) {
                ans.val = root.val;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return ans.val == -1 ? null : ans;
    }

    static TreeNode findFloor (TreeNode root, int target) {
        TreeNode ans = new TreeNode(-1);

        while (root != null) {
            if (root.val < target) {
                ans.val = root.val;
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return ans.val == -1 ? null : ans;
    }
}
