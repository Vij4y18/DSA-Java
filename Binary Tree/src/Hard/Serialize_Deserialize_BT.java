package Hard;

import Nodes.TreeNode;
import Nodes.Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Serialize_Deserialize_BT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String data = serialize(root);
        System.out.println(data);

        TreeNode deSserialize = deserialize(data);

        List<Integer> ans = new ArrayList<>();

        Traversal traversal = new Traversal();
        traversal.preorder(deSserialize, ans);

        System.out.println(ans);
    }

    static String serialize(TreeNode root) {
        StringBuilder data = new StringBuilder();
        serializeTree(root, data);
        return data.toString();
    }

    static void serializeTree (TreeNode root, StringBuilder data) {
        if (root == null) {
            data.append("null").append(",");
            return;
        }

        data.append(root.val).append(",");

        serializeTree(root.left, data);
        serializeTree(root.right, data);
    }

    // Decodes your encoded data to tree.
    static TreeNode deserialize(String data) {
        String[] values = data.split(",");

        Queue<String> Q = new LinkedList<>();
        for (String value : values) {
            Q.offer(value);
        }

        return deserializeTree(Q);
    }

    static TreeNode deserializeTree (Queue<String> Q) {
        String value = Q.poll();
        if (value.equals("null")) return null;

        int num = Integer.parseInt(value);
        TreeNode root = new TreeNode(num);

        if (Q.isEmpty()) return root;

        root.left = deserializeTree(Q);
        root.right = deserializeTree(Q);

        return root;
    }
}
