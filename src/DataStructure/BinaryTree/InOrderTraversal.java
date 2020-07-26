package DataStructure.BinaryTree;

import Util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//中序遍历
public class InOrderTraversal {
    public List<Integer> InOrder(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
