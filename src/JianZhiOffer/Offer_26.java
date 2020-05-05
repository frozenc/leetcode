package JianZhiOffer;

import Util.TreeNode;

import java.util.Stack;

//二叉树转化为双向链表
public class Offer_26 {
    //中序遍历思路，非递归
    public TreeNode Convert(TreeNode pRootOfTree) {
        Stack<TreeNode> stack = new Stack<>();
        if (pRootOfTree == null) return null;
        TreeNode root = null;
        TreeNode cur = pRootOfTree;
        TreeNode pre = null;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (pre == null) {
                pre = cur;
                root = cur;
            } else {
                pre.right = cur;
                cur.left = pre;
                pre = cur;
            }
            cur = cur.right;
        }
        return root;
    }
    //递归思路，左边子树排好，寻找最后的节点连接根节点，再排序右边子树
    public TreeNode Convert2(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode left = Convert(root.left);
        TreeNode p = left;
        while (p != null && p.right != null) {
            p = p.right;
        }
        if (left != null) {
            p.right = root;
            root.left = p;
        }
        TreeNode right = Convert(root.right);
        if (right != null) {
            root.right = right;
            right.left = root;
        }
        return left == null ? root : left;
    }
}
