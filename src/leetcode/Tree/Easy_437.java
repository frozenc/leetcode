package leetcode.Tree;

import Util.TreeNode;

//路径总和
public class Easy_437 {
    //递归实现
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumHelper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int pathSumHelper(TreeNode root, int sum) {
        if (root == null) return 0;
        sum -= root.val;
        return (sum == 0 ? 1 : 0 ) +  pathSumHelper(root.left, sum) + pathSumHelper(root.right, sum);
    }
}
