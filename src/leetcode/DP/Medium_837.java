package leetcode.DP;

//新21点
public class Medium_837 {
    //动态规划，倒着推
    public double new21Game(int N, int K, int W) {
        if(K == 0) return 1.0;
        double[] dp = new double[K+W];
        for (int i=K; i<K+W & i<=N; i++) {
            dp[i] = 1.0;
        }
        dp[K-1] = 1.0 * Math.min(N-K+1, W)/W;
        for (int i=K-2; i>=0; i--) {
            dp[i] = dp[i+1] + (dp[i+1] - dp[i+W+1]) / W;
        }
        return dp[0];
    }
}
