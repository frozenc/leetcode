package leetcode.Tree;

import Util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//二叉树的最大宽度
public class Medium_662 {
    //BFS
    public int widthOfBinaryTree(TreeNode root) {
        Queue<MyNode> queue = new LinkedList<>();
        if (root == null) return 0;
        int width=1;
        queue.offer(new MyNode(root, 0));
        while(!queue.isEmpty()) {
            int n = queue.size();
            int pos = 0, left = queue.peek().pos;
            for (int i=0; i<n; i++) {
                MyNode cur = queue.poll();
                width = Math.max(width, cur.pos-left+1);
                if (cur.node.left != null) queue.offer(new MyNode(cur.node.left, cur.pos*2));
                if (cur.node.right != null) queue.offer(new MyNode(cur.node.right, cur.pos*2+1));
            }
        }
        return width;
    }

    public class MyNode {
        TreeNode node;
        int pos;

        MyNode(TreeNode node, int pos) {
            this.node = node;
            this.pos = pos;
        }
    }
}
