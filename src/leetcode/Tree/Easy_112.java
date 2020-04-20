package leetcode.Tree;

import javafx.util.Pair;
import leetcode.Util.TreeNode;

import java.util.Stack;

//路经总和
public class Easy_112 {
    //无脑回溯
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.val == sum && root.left == null && root.right == null) return true;
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }
    //DFS迭代
    public boolean hasPathSum2(TreeNode root, int sum) {
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        if (root==null) return false;
        stack.push(new Pair<>(root,sum));
        while (!stack.empty()) {
            Pair<TreeNode, Integer> cur = stack.pop();
            TreeNode tmp = cur.getKey();
            System.out.println("node:" + tmp.val + "sum" + cur.getValue());
            if (tmp.left == null && tmp.right == null && tmp.val == cur.getValue()) return true;
            if (tmp.right != null) {
                stack.push(new Pair<>(tmp.right, cur.getValue() - tmp.val));
            }
            if (tmp.left != null) {
                stack.push(new Pair<>(tmp.left, cur.getValue() - tmp.val));
            }
        }
        return false;
    }
}
