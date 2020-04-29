package leetcode.DP;

import java.util.Arrays;

//零钱兑换
public class Medium_322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        //全部用1块硬币填充需要的硬币数+1
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i=1; i<=amount; i++) {
            for (int j=0; j<coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    //自上而下的dp，count数组记录已经计算过的金额
    public int coinChange2(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    public int coinChange(int[] coins, int amount, int[] count) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        //amount-1存放的正是当前amount的兑换需要的硬币数量
        if (count[amount-1] != 0) return count[amount-1];
        int min = Integer.MAX_VALUE;
        for (int coin:coins) {
            int res = coinChange(coins, amount-coin, count);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        count[amount-1] = min == Integer.MAX_VALUE ? -1 : min;
        return count[amount-1];
    }
}
