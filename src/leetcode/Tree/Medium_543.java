package leetcode.Tree;

import leetcode.Util.TreeNode;

//二叉树的直径
public class Medium_543 {
    //计算任意节点的两颗子树的高度之和，直径是边的数目，四个节点三条边
    int path = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        height(root);
        return path;
    }

    public int height(TreeNode node) {
        if (node == null) return 0;
        int left = height(node.left);
        int right = height(node.right);
        path = Math.max(path, left + right);
        return Math.max(left, right) + 1;
    }
}
