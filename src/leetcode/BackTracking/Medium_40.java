package leetcode.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode
 * 2020/9/10 8:58
 * 组合总和
 *
 * @author Chan
 * @since
 **/
public class Medium_40 {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, new ArrayList<Integer>(), 0);
        return res;
    }

    public void helper(int[] candidates, int target, List<Integer> path, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
        }

        for (int i = index; i < candidates.length; i++) {
            //每个重复的数只在回溯刚开始使用一次
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] <= target) {
                path.add(candidates[i]);
                helper(candidates, target - candidates[i], path, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
