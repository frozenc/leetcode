package leetcode.DP;

public class Coins {
    int mod = 1000000007;
    int[] coins = {25,10,5,1};

    public int waysToChange(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int coin:coins) {
            for (int i=coin;i<=n; i++) {
                dp[i] = (dp[i] + dp[i-coin]) % mod;
            }
        }
        return dp[n];
    }

    //数学解法
    public int waysToChange2(int n) {
        long res = 0;
        for (int i=0; i*25<=n; i++) {
            //用25分后剩余的钱
            int rest = n-i*25;
            //最多可用多少个10分
            int a = rest/10;
            //用完10分后可用多少个5分
            int b = rest%10/5;
            res = (res + ((long)(a+1)*(a+b+1))%mod)%mod;
        }
        return (int)res;
    }
}
