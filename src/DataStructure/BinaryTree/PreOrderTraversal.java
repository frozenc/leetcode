package DataStructure.BinaryTree;

import Util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//前序遍历
public class PreOrderTraversal {
    public List<Integer> PreOrder(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                res.add(root.val);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
        return res;
    }
}
