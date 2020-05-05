package JianZhiOffer;

import Util.TreeNode;

//平衡二叉树
public class Offer_39 {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.abs(left - right) < 2 && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public int depth(TreeNode root) {
        if (root == null) return 0;
        return 1+Math.max(depth(root.left), depth(root.right));
    }

    public boolean IsBalanced_Solution2(TreeNode root) {
        return depth2(root) != -1;
    }

    public int depth2(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        if (left == -1) return -1;
        int right = depth(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) < 2 ? 1+Math.max(left, right) : -1;
    }
}
