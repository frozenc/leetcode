package leetcode.Tree;

import leetcode.Util.TreeNode;

//根到叶子节点的数字之和
public class Medium_129 {
    //DFS
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int num) {
        if (root == null) return 0;
        num = num*10 + root.val;
        if (root.left == null && root.right == null) {
            return num;
        }
        return helper(root.left, num) + helper(root.right, num);
    }

}
