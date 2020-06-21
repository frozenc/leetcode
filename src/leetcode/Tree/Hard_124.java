package leetcode.Tree;

import Util.TreeNode;

//二叉树中的最大路径和
public class Hard_124 {
    int res = Integer.MIN_VALUE;
    //递归做法
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
        int all = left + right + root.val;
        int side = Math.max(left, right) + root.val;
        res = Math.max(res, Math.max(all, side));

        return side;
    }
}
