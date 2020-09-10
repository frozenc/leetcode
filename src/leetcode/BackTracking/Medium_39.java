package leetcode.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode
 * 2020/9/9 10:03
 * 组合总和
 *
 * @author Chan
 * @since
 **/
public class Medium_39 {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        helper(new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }

    public void helper(List<Integer> path, int[] candidates, int target, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                path.add(candidates[i]);
                helper(path, candidates, target - candidates[i], i);
                path.remove(path.size() - 1);
            }
        }
    }
}
