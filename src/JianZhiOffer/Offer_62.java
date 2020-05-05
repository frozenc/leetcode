package JianZhiOffer;

import Util.TreeNode;

import java.util.Stack;

//二叉搜索树的第k个节点
public class Offer_62 {
    //中序遍历
    TreeNode KthNode(TreeNode root, int k)
    {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return null;
        int count=1;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (count++ == k) return root;
            root = root.right;
        }
        return null;
    }
}
