package leetcode.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//全排列2，不包含重复组合
public class Medium_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> path = new Stack<>();
        Arrays.sort(nums);
        boolean[] isUsed = new boolean[nums.length];
        dfs(nums, path, isUsed, res);
        return res;
    }

    public void dfs(int[] nums, Stack<Integer> path, boolean[] isUsed, List<List<Integer>> res) {
        if (path.size() == nums.length) res.add(new ArrayList<>(path));
        for (int i=0; i<nums.length; i++) {
            if (isUsed[i]) continue;
            //剪枝，去除重复组合
            if (i>0 && nums[i]==nums[i-1] && !isUsed[i-1]) continue;
            isUsed[i] = true;
            path.push(nums[i]);
            dfs(nums, path, isUsed, res);
            path.pop();
            isUsed[i] = false;
        }
    }
}
