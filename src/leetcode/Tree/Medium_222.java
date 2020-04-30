package leetcode.Tree;

import Util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//完全二叉树的节点
public class Medium_222 {
    //递归实现
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return countNodes(root.right) +  countNodes(root.left) + 1;
    }
    //队列迭代实现
    public int countNodes2(TreeNode root) {
        int count = 1;
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left!=null) {
                queue.offer(cur.left);
                count++;
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                count++;
            }
        }
        return count;
    }
    //二分法，查找，先计算树的高度d-1，计算最后一层有多少个节点，通过二分法，自顶向底查找元素是否存在确定
    public int countNodes3(TreeNode root) {
        if (root == null) return 0;
        int d = depth(root);
        if(d==0) return 1;
        int left = 0, right = (int)Math.pow(2,d)-1;
        while (left <= right) {
            int pivot = left + (right - left)/2;
            if (exist(pivot, d, root)) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return (int)Math.pow(2,d) - 1 + left;
    }

    public int depth(TreeNode root) {
        int depth = 0;
        while (root.left != null) {
            root = root.left;
            depth++;
        }
        return depth;
    }

    public boolean exist(int idx, int d, TreeNode root) {
        int left = 0, right = (int)Math.pow(2,d)-1;
        int pivot;
        for(int i=0; i<d; i++) {
            pivot = left + (right-left)/2;
            if (idx<=pivot) {
                root = root.left;
                right = pivot;
            } else {
                root = root.right;
                left = pivot + 1;
            }
        }
        return root != null;
    }
}
