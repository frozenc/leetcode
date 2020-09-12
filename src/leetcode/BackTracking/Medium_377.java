package leetcode.BackTracking;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode
 * 2020/9/12 11:19
 * 组合总和4
 *
 * @author Chan
 * @since
 **/
public class Medium_377 {
    //记忆化搜索
    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int res = helper(nums, target, map);
        return res;
    }

    public int helper(int[] nums, int target, Map<Integer, Integer> map) {
        if (map.containsKey(target)) {
            return map.get(target);
        }

        int res = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] <= target) {
                res += helper(nums, target - nums[i], map);
            }
        }

        map.put(target, res);
        return res;
    }

    //动态规划
    public int combinationSum4_2(int[] nums, int target) {
        int[] dp = new int[target + 1];
        //初始值，nums里面刚好有一个target的值
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i-num];
                }
            }
        }
        return dp[target];
    }
}
