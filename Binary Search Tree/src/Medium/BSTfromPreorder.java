package Medium;

import Nodes.TreeNode;

public class BSTfromPreorder {
    public static void main(String[] args) {
        int[] preorder = {8,5,1,7,10,12};
        TreeNode root = constructBST(preorder, Integer.MAX_VALUE);
        System.out.println(root.val);
    }

    static int index = 0; // creating global variable for tracking index
    // you can also use an array to pass by reference

    static TreeNode constructBST (int[] preorder, int upperBound) {
        if (index >= preorder.length || preorder[index] > upperBound) return null;

        TreeNode root = new TreeNode(preorder[index]);
        index++;


        root.left = constructBST(preorder, root.val);
        root.right = constructBST(preorder, upperBound);

        return root;
    }
}
