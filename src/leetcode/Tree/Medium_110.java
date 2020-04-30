package leetcode.Tree;

import Util.TreeNode;

//平衡二叉树
public class Medium_110 {
    //暴力法，自顶向下，计算高度，递归计算平衡性，计算复杂度较高
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = height(root.left);
        int right = height(root.right);
        return Math.abs(left-right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root) {
        if (root == null) return 0;
        return 1+Math.max(height(root.left), height(root.right));
    }
    //自底向上，发现不平衡提前返回
    public boolean isBalanced2(TreeNode root) {
        return helper(root) != -1;
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        if (left == -1) return -1;
        int right = helper(root.right);
        if (right == -1) return -1;
        return Math.abs(left-right) < 2 ? Math.max(left,right)+1 : -1;
    }
}
