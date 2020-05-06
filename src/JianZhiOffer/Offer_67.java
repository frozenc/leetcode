package JianZhiOffer;

//剪绳子
public class Offer_67 {
    public int cutRope(int target) {
        int[] dp = new int[target+1];
        if (target <= 1) return 0;
        if (target == 2) return 1;
        if (target == 3) return 2;
        dp[0] = 0;
        dp[1] = 1;
        //绳子大于2，可以剪2
        dp[2] = 2;
        //绳子大于3，可以剪3
        dp[3] = 3;
        for (int i=4; i<=target; i++) {
            dp[i] = Integer.MIN_VALUE;
            for (int j=1; j<i; j++) {
                dp[i] = Math.max(dp[i], dp[j]*dp[i-j]);
            }
        }
        return dp[target];
    }
}
