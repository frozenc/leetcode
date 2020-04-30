package leetcode.Tree;

import Util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Easy_257 {
    List<String> res = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        binaryTreePathsHelp(root, "");
        return res;
    }

    public void binaryTreePathsHelp(TreeNode root, String s) {
        StringBuilder sb = new StringBuilder(s);
        if (root == null) return;
        // System.out.println(root.val);
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
            return;
        }
        sb.append("->");
        binaryTreePathsHelp(root.left, sb.toString());
        binaryTreePathsHelp(root.right, sb.toString());
    }
    //BFS
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<String> resQueue = new LinkedList<>();
        queue.offer(root);
        resQueue.offer(Integer.toString(root.val));
        String path;
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            path = resQueue.poll();
            if (curNode.left == null && curNode.right == null) {
                res.add(path);
            }
            if (curNode.left != null) {
                queue.offer(curNode.left);
                resQueue.offer(path + "->" + curNode.left.val);
            }
            if (curNode.right != null) {
                queue.offer(curNode.right);
                resQueue.offer(path + "->" + curNode.right.val);
            }
        }
        return res;
    }
}
