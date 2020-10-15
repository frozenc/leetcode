package leetcode.Tree;

import Util.NextNode.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode
 * 2020/10/15 20:52
 * 二叉树节点的下一个右侧指针
 *
 * @author Frozen Chan
 * @since
 **/
public class Medium_116 {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i ++) {
                Node node = queue.poll();

                if (i < size - 1) {
                    node.next = queue.peek();
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    //利用已经连接的上一层
    public Node connect2(Node root) {
        if (root == null) {
            return root;
        }
        Node leftmost = root;
        while (leftmost.left != null) {
            Node head = leftmost;
            while (head != null) {
                head.left.next = head.right;

                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                head = head.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }
}
