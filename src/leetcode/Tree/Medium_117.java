package leetcode.Tree;

import Util.NextNode.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode
 * 2020/9/28 13:28
 * 二叉树的右侧节点
 *
 * @author Frozen Chan
 * @since
 **/
public class Medium_117 {
    //BFS层次遍历
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {

            Node cur = null;
            Node next = null;
            int len = queue.size();
            for (int i = 0; i < len; i ++) {
                if (cur == null) {
                    cur = queue.poll();
                } else {
                    next = queue.poll();
                    cur.next = next;
                    cur = next;
                }

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return root;
    }
}
