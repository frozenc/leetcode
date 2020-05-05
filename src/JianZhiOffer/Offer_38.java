package JianZhiOffer;

import Util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//二叉树的深度
public class Offer_38 {
    //递归很简单
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }
    //非递归
    public int TreeDepth2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return 0;
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            count++;
            for (int i=0; i<n; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
        return count;
    }
}
