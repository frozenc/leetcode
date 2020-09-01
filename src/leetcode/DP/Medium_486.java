package leetcode.DP;

/**
 * leetcode
 * 2020/9/1 10:20
 * 预测赢家
 *
 * @author Chan
 * @since
 **/
public class Medium_486 {
    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        int[][] memo = new int[len][len];
        return helper(memo, nums, 0, nums.length-1) >= 0;
    }

    public int helper(int[][] memo, int[] nums, int left, int right) {
        if (memo[left][right] != 0) {
            return memo[left][right];
        }
        if (left == right) {
            return nums[left];
        }
        int pickLeft = nums[left] - helper(memo, nums, left + 1, right);
        int pickRight = nums[right] - helper(memo, nums, left, right - 1);
        memo[left][right] = Math.max(pickLeft, pickRight);
        return memo[left][right];
    }

    public boolean PredictTheWinner2(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i ++) {
            dp[i][i] = nums[i];
        }

        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                int pickLeft = nums[i] - dp[i+1][j];
                int pickRight = nums[j] - dp[i][j-1];
                dp[i][j] = Math.max(pickLeft, pickRight);
            }
        }

        return dp[0][len-1] >= 0;
    }
}
