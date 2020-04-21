package leetcode.Tree;

import leetcode.Util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//翻转二叉树
public class Easy_226 {
    //递归完事
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
    //BFSDFS
    public TreeNode invertTree2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            TreeNode tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        return root;
    }
}
