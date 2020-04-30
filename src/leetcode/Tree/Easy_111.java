package leetcode.Tree;

import javafx.util.Pair;
import Util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//二叉树的最小深度
public class Easy_111 {
    //递归实现
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return root.left == null || root.right == null ? left + right + 1: Math.min(left,right)+1;
    }

    //BFS实现
    public int minDepth2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            depth ++;
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode tmp = queue.poll();
                if (tmp.left == null && tmp.right == null) return depth;
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
        }
        return depth;
    }

    //DFS实现
    public int minDepth3(TreeNode root) {
        Stack<Pair<TreeNode, Integer>> stack = new Stack<Pair<TreeNode, Integer>>();
        if (root != null) stack.push(new Pair<>(root, 1));
        int depth = 0, min = Integer.MAX_VALUE;
        while (!stack.empty()) {
            Pair<TreeNode, Integer> tmp = stack.pop();
            TreeNode cur = tmp.getKey();
            depth = tmp.getValue();
            if (cur.left == null && cur.right == null) min = Math.min(min, depth);
            if (cur.left != null) {
                stack.push(new Pair<>(cur.left, depth+1));
            }
            if (cur.right != null) {
                stack.push(new Pair<>(cur.right, depth+1));
            }
        }
        return depth == 0 ? depth : min;
    }
}
