package leetcode.Tree;

import leetcode.Util.TreeNode;

import java.util.ArrayList;
import java.util.List;

//路经总和2
public class Medium_113 {
    //递归实现
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, sum, new ArrayList<Integer>());
        return res;
    }

    public void helper(TreeNode root, int sum, List<Integer> list) {
        if (root == null) return;
        sum -= root.val;
        list.add(root.val);
        if (sum == 0 && root.left== null && root.right == null) {
            res.add(new ArrayList<>(list));
        } else {
            helper(root.left, sum, list);
            helper(root.right, sum, list);
        }
        list.remove(list.size()-1);
        return;
    }
}
