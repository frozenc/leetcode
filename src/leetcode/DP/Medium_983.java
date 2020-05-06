package leetcode.DP;

//最低票价
public class Medium_983 {
    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        int[] dp = new int[days[len-1] + 1];
        int[] valid = new int[]{1,7,30};
        dp[0] = 0;
        int index = 0;
        for (int i=1; i<dp.length; i++) {
            if (i != days[index]) {
                dp[i] = dp[i-1];
            } else {
                index++;
                dp[i] = Integer.MAX_VALUE;
                for (int j=0; j<valid.length; j++) {
                    dp[i] = Math.min(dp[i], dp[Math.max(0, i-valid[j])] + costs[j]);
                }
            }
        }
        return dp[dp.length-1];
    }

    public int mincostTickets2(int[] days, int[] costs) {
        int len = days.length;
        int[] dp = new int[len];
        int[] valid = new int[]{1,7,30};
        dp[0] = Integer.MAX_VALUE;
        for (int cost:costs) {
            dp[0] = Math.min(cost, dp[0]);
        }
        int index = 0;
        for (int i=1; i<len; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j=0; j<valid.length; j++) {
                int k=i;
                //寻找票期限前的天数
                while (k>=0 && days[i]-valid[j] < days[k]) k--;
                if (k < 0) dp[i] = Math.min(dp[i], 0+costs[j]);
                else {
                    dp[i] = Math.min(dp[i], dp[k]+costs[j]);
                }
            }
        }
        return dp[len-1];
    }
}
