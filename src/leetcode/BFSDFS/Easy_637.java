package leetcode.BFSDFS;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * leetcode
 * 2020/9/12 9:50
 * 二叉树的层平均值
 *
 * @author Chan
 * @since
 **/
public class Easy_637 {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Double> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int len = queue.size();
            double sum = 0.0;
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(sum / len);
        }
        return res;
    }
}
