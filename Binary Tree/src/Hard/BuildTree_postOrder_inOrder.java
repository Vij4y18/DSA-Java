package Hard;

import Nodes.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTree_postOrder_inOrder {
    public static void main(String[] args) {
        int[] postorder = {9,15,7,20,3};
        int[] inorder = {9,3,15,20,7};

        TreeNode ans = buildTree(inorder, postorder);

        System.out.println(ans.val);
    }

    static TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();

        for (int i=0; i<inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return buildTree (postorder, 0, postorder.length-1, inorder, 0, inorder.length-1, inMap);
    }

    static TreeNode buildTree (int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if (postStart > postEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(postorder[postEnd]);

        int inRoot = inMap.get(root.val);
        int numsright = inEnd - inRoot;

        root.left = buildTree (postorder, postStart, postEnd-numsright-1, inorder, inStart, inRoot-1, inMap);

        root.right = buildTree(postorder, postEnd-numsright, postEnd-1, inorder, inRoot+1, inEnd, inMap);

        return root;
    }
}
