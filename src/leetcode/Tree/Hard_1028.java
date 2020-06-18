package leetcode.Tree;

import Util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

//从先序遍历还原二叉树
public class Hard_1028 {
    //利用辅助栈，根据高度以及栈的深度判断栈顶节点是不是当前节点的父节点
    public TreeNode recoverFromPreorder(String S) {
        int len = S.length();
        if (len == 0) {
            return null;
        }
        int index = 0;
        while (index < len && !S.substring(index, index+1).equals("-")) {
            index ++;
        }
        TreeNode root = new TreeNode(Integer.parseInt(S.substring(0, index)));
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (index < len) {
            int count = 0;
            while (S.substring(index, index+1).equals("-")) {
                count ++;
                index ++;
            }
            int num = index;
            while (num < len && !S.substring(num, num + 1).equals("-")) {
                num ++;
            }
            while (count < stack.size()) {
                stack.pop();
            }

            TreeNode cur = stack.peek();
            TreeNode node = new TreeNode(Integer.parseInt(S.substring(index, num)));
            stack.push(node);
            if (cur.left == null) {
                cur.left = node;
            } else {
                cur.right = node;
            }
            index = num;
        }
        return root;
    }

    //更简洁的写法
    public TreeNode recoverFromPreorder2(String S) {
        int len = S.length();
        if (len == 0) {
            return null;
        }
        int index = 0;
        Deque<TreeNode> stack = new LinkedList<>();

        while (index < len) {
            int count = 0;
            while (S.substring(index, index+1).equals("-")) {
                count ++;
                index ++;
            }
            int num = index;
            while (num < len && !S.substring(num, num + 1).equals("-")) {
                num ++;
            }

            TreeNode node = new TreeNode(Integer.parseInt(S.substring(index, num)));
            if (count == stack.size()) {
                if (!stack.isEmpty()) {
                    stack.peek().left = node;
                }
            } else {
                while (count < stack.size()) {
                    stack.pop();
                }
                stack.peek().right = node;
            }
            stack.push(node);

            index = num;
        }
        while (stack.size() > 1) {
            stack.pop();
        }
        return stack.peek();
    }
}
