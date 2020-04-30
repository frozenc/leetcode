package leetcode.Tree;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//二叉树的右视图
public class Medium_199 {
    List<Integer> res = new LinkedList<>();
    //DFS
    public List<Integer> rightSideView(TreeNode root) {
        DFS(root, 0);
        return res;
    }

    public void DFS(TreeNode node, int depth) {
        if (node == null) return;
        if (depth == res.size()) res.add(node.val);
        depth ++;
        DFS(node.right, depth);
        DFS(node.left, depth);
    }

    //BFS，寻找右边的第一个节点
    public List<Integer> rightSideView2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null)  return res;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i=0; i<n; i++ ) {
                TreeNode cur = queue.poll();
                if (i == 0) res.add(cur.val);
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
            }
        }
        return res;
    }
}
