package leetcode.Tree;

import Util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//二叉树的序列化
public class Hard_297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return sb.toString();
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    sb.append("#,");
                } else {
                    sb.append(String.valueOf(cur.val) + ',');
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        int len = strs.length;
        if (len == 0 || strs[0].length() == 0) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(0);
        int index = 0;
        root.val = Integer.parseInt(strs[index++]);
        queue.offer(root);
        TreeNode cur = null;
        while (index < len) {
            cur = queue.poll();
            String str = strs[index++];
            if (str.equals("#")) {
                cur.left = null;
            } else {
                cur.left = new TreeNode(Integer.parseInt(str));
                queue.offer(cur.left);
            }
            str = strs[index++];
            if (str.equals("#")) {
                cur.right = null;
            } else {
                cur.right = new TreeNode(Integer.parseInt(str));
                queue.offer(cur.right);
            }
        }
        return root;
    }
}
