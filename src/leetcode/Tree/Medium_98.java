package leetcode.Tree;

import Util.TreeNode;

import java.util.Stack;

//验证二叉搜索树
public class Medium_98 {
    //递归做法
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode node, Integer left, Integer right) {
        if (node == null) return true;

        if (left != null && node.val <= left) return false;
        if (right != null && node.val >= right) return false;

        if (!helper(node.left, left, node.val)) return false;
        if (!helper(node.right, node.val, right)) return false;

        return true;
    }
    //迭代做法,其实就是中序遍历
    public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double inorder = -Double.MAX_VALUE;
        while (!stack.empty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Double.MAX_VALUE);
        System.out.println(Float.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Double.MAX_VALUE + Double.MIN_VALUE);
        System.out.println(Double.MIN_VALUE);
    }
}
