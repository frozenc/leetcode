package leetcode.Tree;

import leetcode.Util.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

//相同的树
public class Easy_100 {
    //回溯
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p != null && q!=null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
    //层次遍历
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (!check(p, q)) return false;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(p);
        q2.add(q);
        while (!q1.isEmpty()) {
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();
            if (!check(node1, node2)) return false;
            if (node1 != null) {
                q1.add(node1.left);
                q1.add(node1.right);
            }
            if (node2 != null) {
                q2.add(node2.left);
                q2.add(node2.right);
            }
        }
        return true;
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q==null) return false;
        if (p.val == q.val) return true;
        return false;
    }
}
