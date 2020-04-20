package leetcode.Tree;

import leetcode.Util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//层次遍历
public class Medium_102 {
    //BFS队列实现
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int n = queue.size();
            for (int i=0; i<n; i++) {
                TreeNode node = queue.poll();
                // System.out.println("nodesize:" + queue.size() + "node" + node.val);
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(list);
        }
        return res;
    }
}
