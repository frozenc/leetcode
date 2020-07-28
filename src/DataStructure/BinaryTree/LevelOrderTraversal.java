package DataStructure.BinaryTree;

import Util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//层次遍历
public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> line = new LinkedList<>();
            for (int i=0; i<len; i++) {
                TreeNode cur = queue.poll();
                line.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(line);
        }
        return res;
    }
    //自底向上
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> line = new LinkedList<>();
            for (int i=0; i<len; i++) {
                TreeNode cur = queue.poll();
                line.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.addFirst(line);
        }
        return res;
    }

    //Z字形遍历
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        boolean flag = true;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            LinkedList<Integer> line = new LinkedList<>();
            for (int i=0; i<len; i++) {
                TreeNode cur = queue.poll();
                if (flag) {
                    line.add(cur.val);
                } else {
                    line.addFirst(cur.val);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(line);
            flag = flag == true ? false : true;
        }
        return res;
    }
}
