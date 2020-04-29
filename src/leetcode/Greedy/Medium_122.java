package leetcode.Greedy;

//股票买卖时机
public class Medium_122 {
    //只要第二天股价高，就卖出套利
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i=1; i<prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
    //寻找峰谷值
    public int maxProfit2(int[] prices) {
        int profit = 0;
        int valley = prices[0];
        int peak = prices[0];
        for (int i=0; i<prices.length; i++) {
            while(i<prices.length-1 && prices[i+1] < prices[i]) i++;
            valley = prices[i];
            while(i<prices.length-1 && prices[i+1] > prices[i]) i++;
            peak = prices[i];
            profit += peak - valley;
        }
        return profit;
    }
}
