package leetcode.Tree;

import leetcode.Util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//二叉搜索树中的第k小元素
public class Medium_230 {
    //中序遍历，优化
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return -1;
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (--k == 0) return cur.val;
            cur = cur.right;
        }
        return -1;
    }
    //中序遍历
    public int kthSmallest2(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return -1;
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list.get(k-1);
    }
}
