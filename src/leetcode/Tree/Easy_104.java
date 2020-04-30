package leetcode.Tree;


import javafx.util.Pair;
import Util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//查找二叉树深度
public class Easy_104 {
    //递归查找
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    //BFSDFS
    public int maxDepth2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) queue.add(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth ++;
            for (int i=0; i<size; i++) {
                TreeNode tmp = queue.poll();
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
        }
        return depth;
    }

    //DFS
    public int maxDepth3(TreeNode root) {
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        int depth = 0, maxDepth = 0;
        if (root != null) {
            stack.push(new Pair<>(root, 1));
        }
        while (!stack.empty()) {
            //取出栈顶元素
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode cur = pair.getKey();
            //取出当前节点得深度
            depth = pair.getValue();
            maxDepth = Math.max(depth, maxDepth);
            if (cur.left != null) {
                //记录当前节点得深度
                stack.push(new Pair<>(cur.left, depth+1));
            }
            if (cur.right != null){
                stack.push(new Pair<>(cur.right, depth+1));
            }
        }
        return maxDepth;
    }
}
