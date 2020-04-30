package leetcode.Tree;

import Util.TreeNode;

//有序数组转高度平衡二叉搜索树
public class Easy_108 {
    //中序遍历
    int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length-1);
    }

    public TreeNode helper(int left, int right) {
        if (left>right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(left, mid-1);
        root.right = helper(mid+1, right);
        return root;
    }
}
