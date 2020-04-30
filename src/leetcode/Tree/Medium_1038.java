package leetcode.Tree;

import Util.TreeNode;

//从二叉搜索树到更大和树
public class Medium_1038 {
    //右中左遍历
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            if (root.right != null) {
                bstToGst(root.right);
            }
            root.val += sum;
            sum = root.val;
            if (root.left != null) {
                bstToGst(root.left);
            }
        }
        return root;
    }

    //右中左遍历
    public TreeNode bstToGst2(TreeNode root) {
        updateTree(root, 0);
        return root;
    }

    public int updateTree(TreeNode root, int parentSum) {
        if (root == null) return parentSum;
        int right = updateTree(root.right, parentSum);
        root.val += right;
        int left = updateTree(root.left, root.val);
        return left;
    }
}
