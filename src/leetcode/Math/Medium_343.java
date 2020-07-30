package leetcode.Math;

//整数拆分
public class Medium_343 {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        for (int k = 2; k<=n; k++) {
            for (int i = 1; i < k; i++) {
                dp[k] = Math.max(dp[k], Math.max(i*(k-i), i * dp[k-i]));
            }
        }
        return dp[n];
    }
}
