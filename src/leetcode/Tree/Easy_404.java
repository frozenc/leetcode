package leetcode.Tree;

import javafx.util.Pair;
import Util.TreeNode;

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
}
