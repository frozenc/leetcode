package leetcode.Tree;

import javafx.util.Pair;
import Util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//左叶子之和
public class Easy_404 {
    //回溯实现
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeavesHelp(root, false);
    }

    public int sumOfLeftLeavesHelp(TreeNode root, boolean leftChild) {
        if (root == null) return 0;
        if (root.left == null && root.right == null && leftChild) return root.val;
        int left = root.left == null ? 0 : sumOfLeftLeavesHelp(root.left, true);
        int right = root.right == null ? 0: sumOfLeftLeavesHelp(root.right, false);
        return left + right;
    }

    //DFS
    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) return 0;
        Stack<Pair<TreeNode, Boolean>> stack = new Stack<>();
        stack.push(new Pair<>(root, false));
        int res = 0;
        while (!stack.empty()) {
            Pair<TreeNode, Boolean> tmp = stack.pop();
            TreeNode node = tmp.getKey();
            boolean flag = tmp.getValue();
            if (node.left == null && node.right == null && flag) res += node.val;
            if (node.left != null) {
                stack.push(new Pair<>(node.left, true));
            }
            if (node.right != null) {
                stack.push(new Pair<>(node.right, false));
            }
        }
        return res;
    }

    //BFS
    public int sumOfLeftLeaves3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                TreeNode left = cur.left;
                if (left.left == null && left.right == null) {
                    sum += left.val;
                } else {
                    queue.offer(left);
                }
            }
            if (cur.right != null) {
                TreeNode right = cur.right;
                if (right.left != null || right.right != null) {
                    queue.offer(right);
                }
            }
        }
        return sum;
    }

    public int sumOfLeftLeaves4(TreeNode root) {
        return root == null ? 0 : dfs(root);
    }

    public int dfs(TreeNode root) {
        int ans = 0;
        if (root.left != null) {
            ans += isLeafNode(root.left) ? root.left.val : dfs(root.left);
        }
        if (root.right != null) {
            ans += isLeafNode(root.right) ? 0 : dfs(root.right);
        }
        return ans;
    }

    public boolean isLeafNode(TreeNode node) {
        if (node.left == null && node.right == null) {
            return true;
        }
        return false;
    }
}
