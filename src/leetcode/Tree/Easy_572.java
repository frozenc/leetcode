package leetcode.Tree;

import Util.TreeNode;

//树的子结构
public class Easy_572 {
    public boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val == t.val) {
            boolean left = isSame(s.left, t.left);
            boolean right = isSame(s.right, t.right);
            return left && right;
        }
        return false;
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true;   // t 为 null 一定都是 true
        if (s == null) return false;  // 这里 t 一定不为 null, 只要 s 为 null，肯定是 false
        return isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(0);
        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(2);
        System.out.println(new Easy_572().isSubtree(root, root2));
    }
}
