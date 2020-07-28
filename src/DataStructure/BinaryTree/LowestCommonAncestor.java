package DataStructure.BinaryTree;

import Util.TreeNode;

//最近公共祖先
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //左边=null， lca肯定在右边
        // 左边!=null,右边=null,lca肯定在左边
        //左!= null. 右!=null，lca就是root
        return left == null ? right : right == null ? left : root;

    }
}
