package JianZhiOffer;

import Util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//树的子结构
public class Offer_17 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root2 == null || root1 == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.val == root2.val) {
                if (isSubTree(cur, root2)) {
                    return true;
                }
            }
            if (cur.left != null) queue.offer(cur.left);
            if (cur.right != null) queue.offer(cur.right);
        }
        return false;
    }

    public boolean isSubTree(TreeNode root, TreeNode root2) {
        //只要root2为空即可
        if (root2 == null) return true;
        if (root == null) return false;
        if (root.val == root2.val) {
            boolean left = isSubTree(root.left, root2.left);
            boolean right = isSubTree(root.right, root2.right);
            return left && right;
        } else {
            return false;
        }
    }
}
