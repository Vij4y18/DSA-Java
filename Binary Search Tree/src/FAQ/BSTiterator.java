package FAQ;

import Nodes.TreeNode;

import java.util.Stack;

class Iterator {
    Stack<TreeNode> st = new Stack<>();

    public Iterator(TreeNode root) {
        push(root);
    }

    public void push (TreeNode root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode curr = st.pop();
        push(curr.right);
        return curr.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}

public class BSTiterator {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);

        root.left = new TreeNode(3);

        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        Iterator obj = new Iterator(root);

        System.out.println(obj.next());     // 3
        System.out.println(obj.next());     // 7
        System.out.println(obj.hasNext());  // true
        System.out.println(obj.next());     // 9
        System.out.println(obj.hasNext());  // true
        System.out.println(obj.next());     // 15
        System.out.println(obj.hasNext());  // true
        System.out.println(obj.next());     // 20
        System.out.println(obj.hasNext());  // false
    }
}
