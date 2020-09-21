package leetcode.Tree;

import Util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * leetcode
 * 2020/9/21 10:52
 * 累加树
 *
 * @author Chan
 * @since
 **/
public class Easy_538 {
    //递归做法
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    //迭代做法
    public TreeNode convertBST2(TreeNode root) {
        if (root == null) {
            return root;
        }
        int sum = 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            sum += cur.val;
            cur.val = sum;
            cur = cur.left;
        }
        return root;
    }

    //Morris遍历
    public TreeNode convertBST3(TreeNode root) {
        int sum = 0;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.right == null) {
                sum += cur.val;
                cur.val = sum;
                cur = cur.left;
            } else {
                TreeNode suc = getSuccessor(cur);
                if (suc.left == null) {
                    suc.left = cur;
                    cur = cur.right;
                } else {
                    suc.left = null;
                    sum += cur.val;
                    cur.val = sum;
                    cur = cur.left;
                }
            }
        }
        return root;
    }

    public TreeNode getSuccessor(TreeNode root) {
        TreeNode cur = root.right;
        while (cur.left != null && cur.left != root) {
            cur = cur.left;
        }
        return cur;
    }
}
