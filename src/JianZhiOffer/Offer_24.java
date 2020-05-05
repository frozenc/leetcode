package JianZhiOffer;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

//二叉树中和为某值的路径
public class Offer_24 {
    //dfs遍历
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        dfs(res, root, target, new ArrayList<Integer>());
        return res;
    }

    public void dfs(ArrayList<ArrayList<Integer>> res, TreeNode root, int target, ArrayList<Integer> path) {
        if (root == null) return;
        path.add(root.val);
        if (root.val == target) {
            if (root.left == null && root.right == null) {
                res.add(new ArrayList<>(path));
            }
        } else if (root.val < target) {
            dfs(res, root.left, target - root.val, path);
            dfs(res, root.right, target - root.val, path);
        }
        path.remove((Integer)root.val);
        return;
    }
}
