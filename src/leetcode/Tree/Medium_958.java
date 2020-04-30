package leetcode.Tree;

import Util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//二叉树的完全验证
public class Medium_958 {
    //flag判断是否出现null，出现null后再出现节点即为不完全
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return true;
        queue.offer(root);
        boolean flag = false;
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                if (flag) return false;
                queue.offer(cur.left);
            } else if(!flag) {
                flag = true;
            }
            if (cur.right != null) {
                if (flag) return false;
                queue.offer(cur.right);
            } else if (!flag) {
                flag = true;
            }
        }
        return true;
    }
}
