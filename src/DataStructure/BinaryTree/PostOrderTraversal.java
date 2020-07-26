package DataStructure.BinaryTree;

import Util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//后序遍历
public class PostOrderTraversal {
    public List<Integer> PostOrder(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                res.addFirst(root.val);
                root = root.right;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.left;
            }
        }
        return res;
    }
}
