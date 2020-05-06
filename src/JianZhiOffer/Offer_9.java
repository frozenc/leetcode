package JianZhiOffer;

//变态跳台阶
public class Offer_9 {
    public int JumpFloorII(int target) {
        if (target <= 0) return 0;
        if (target == 1) return 1;
        int[] dp = new int[target+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i=2; i<=target; i++) {
            dp[i] += 1;
            for (int j=0; j<i; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[target];
    }
}
