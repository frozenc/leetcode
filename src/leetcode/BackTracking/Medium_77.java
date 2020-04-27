package leetcode.BackTracking;

import java.util.*;

//组合
public class Medium_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> path = new Stack<>();
        helper(n, 1, path, k, res);
        return res;

    }

    public void helper(int n, int start, Stack<Integer> path, int k, List<List<Integer>> res) {
        if (k == 0) res.add(new ArrayList<>(path));
        for (int i=start; i<=n; i++) {
            path.push(i);
            helper(n, i+1, path, k-1, res);
            path.pop();
        }
    }
}
