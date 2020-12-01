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

    int remain;
    TreeNode ans;

    TreeNode KthNode2(TreeNode pRoot, int k)
    {
        this.remain = k;
        dfs(pRoot);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null || this.remain < 1) {
            return;
        }
        dfs(root.left);
        if (this.remain == 1) {
            ans = root;
        }
        this.remain --;
        dfs(root.right);
    }
}
