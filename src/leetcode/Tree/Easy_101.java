package leetcode.Tree;

import Util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//对称二叉树
public class Easy_101 {
    //递归实现
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSame(root.left, root.right);
    }

    public boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isSame(left.left, right.right) && isSame(left.right, right.left);
    }

    //迭代实现
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();
            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null) return false;
            if (n1.val != n2.val) return false;
            queue.offer(n1.left);
            queue.offer(n2.right);
            queue.offer(n1.right);
            queue.offer(n2.left);
        }
        return true;
    }
}
