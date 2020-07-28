package DataStructure.BinaryTree;

import Util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

//判断是不是二叉搜索树
public class ValidBinaryTree {
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        double inorder = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.println("inorder:" + inorder + "-root:" + root.val);
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
