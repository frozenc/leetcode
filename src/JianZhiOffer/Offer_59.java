package JianZhiOffer;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

//按之字形打印数组
public class Offer_59 {
    //两个栈实现
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        if (pRoot == null) return res;
        stack.push(pRoot);
        int count = 0;
        while (!stack.isEmpty() || !stack2.isEmpty()) {
            ArrayList<Integer> line = new ArrayList<>();
            if (count % 2 == 0) {
                int n = stack.size();
                for (int i=0; i<n; i++) {
                    TreeNode cur = stack.pop();
                    line.add(cur.val);
                    if (cur.left != null) stack2.push(cur.left);
                    if (cur.right != null) stack2.push(cur.right);
                }
            } else {
                int n = stack2.size();
                for (int i=0; i<n; i++) {
                    TreeNode cur = stack2.pop();
                    line.add(cur.val);
                    if (cur.right != null) stack.push(cur.right);
                    if (cur.left != null) stack.push(cur.left);
                }
            }
            count++;
            res.add(line);
        }
        return res;
    }
}
