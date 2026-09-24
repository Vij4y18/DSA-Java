package FAQ;

import Nodes.TreeNode;

import java.util.Stack;

class BSTIterator {
    Stack<TreeNode> nextStack = new Stack<>();
    Stack<TreeNode> beforeStack = new Stack<>();

    public BSTIterator (TreeNode root) {
        push(root, nextStack, true);
        push(root, beforeStack, false);
    }

    public int next() {
        if (nextStack.isEmpty()) return Integer.MAX_VALUE;
        TreeNode curr = nextStack.pop();
        push(curr.right, nextStack, true);
        return curr.val;
    }

    public int before() {
        if (beforeStack.isEmpty()) return Integer.MIN_VALUE;
        TreeNode curr = beforeStack.pop();
        push(curr.left, beforeStack, false);
        return curr.val;
    }

    public void push (TreeNode root, Stack<TreeNode> st, boolean flag) {
        while (root != null) {
            st.push(root);
            if (flag) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }
}

public class TwoSum {
    static boolean findTarget(TreeNode root, int k) {

        BSTIterator obj = new BSTIterator(root);
        int low = obj.next();
        int high = obj.before();

        while (low < high) {
            if (low + high == k) {
                return true;
            } else if (low + high < k) {
                low = obj.next();
            } else {
                high = obj.before();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(7);

        int k = 9;

        System.out.println(findTarget(root, k));
    }
}
