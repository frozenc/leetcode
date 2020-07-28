package DataStructure.BinaryTree;

import Util.TreeNode;

//查找二叉树中的最大路径
public class MaxPathSum {
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        int both = left + root.val + right;
        res = Math.max(both, res);
        return Math.max(left, right) + root.val;
    }
}
