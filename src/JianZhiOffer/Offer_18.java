package JianZhiOffer;

import Util.TreeNode;

//二叉树的镜像
public class Offer_18 {
    //递归翻转
    public void Mirror(TreeNode root) {
        if(root == null) return;

        Mirror(root.left);
        Mirror(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
