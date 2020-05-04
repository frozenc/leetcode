package JianZhiOffer;

import Util.TreeNode;

//对称的二叉树
public class Offer_58 {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null) return true;
        return helper(pRoot.left, pRoot.right);

    }

    boolean helper(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        if (n1.val == n2.val) {
            return helper(n1.left, n2.right) && helper(n1.right, n2.left);
        }
        return false;
    }
}
