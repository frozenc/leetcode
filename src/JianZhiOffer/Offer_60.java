package JianZhiOffer;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//把二叉树打印成多行
public class Offer_60 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            ArrayList<Integer> line = new ArrayList<>();
            int n = queue.size();
            for (int i=0; i<n; i++) {
                TreeNode cur = queue.poll();
                line.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            res.add(line);
        }
        return res;
    }
}
