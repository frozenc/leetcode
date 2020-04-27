package leetcode.BackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//组合总和3
public class Medium_216 {
    //简单回溯，dfs剪枝
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k == 0 || n<1) return res;
        helper(res, 1, n, k, new Stack<Integer>());
        return res;
    }

    public void helper(List<List<Integer>> res, int start, int n, int k, Stack<Integer> path) {
        if (n < 0 || (n!=0 && k==0)) return;
        if (n == 0 && k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=start; i<10; i++) {
            if (n-i < 0) continue;
            path.push(i);
            helper(res, i+1, n-i, k-1, path);
            path.pop();
        }
    }
}
