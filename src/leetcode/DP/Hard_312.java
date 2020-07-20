package leetcode.DP;

//戳气球
public class Hard_312 {
    public int maxCoins(int[] nums) {
        int len = nums.length;

        int[][] dp = new int[len+2][len+2];
        //构建虚拟边界，+2是因为两端的1
        int[] val = new int[len+2];
        val[0] = 1;
        val[len+1] = 1;
        for (int i=1; i<=len; i++) {
            val[i] = nums[i-1];
        }
        // 选定左端点气球,保证i >= j-1, 不能变换顺序，算出dp[0][3]的时候，需要依赖的dp[2][3]先算出
        for (int i=len-1; i>=0; i--) {
            //选定右端点气球
            for (int j=i+2; j<=len+1; j++) {
                //在开区间内选气球
                for (int k=i+1; k<j; k++) {
                    int sum = val[i] * val[k] * val[j];
                    sum += dp[i][k] + dp[k][j];
                    dp[i][j] = Math.max(dp[i][j], sum);
                }
            }
        }
        return dp[0][len+1];
    }
}
