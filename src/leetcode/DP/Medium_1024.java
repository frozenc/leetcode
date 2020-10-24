package leetcode.DP;

import java.util.Arrays;

/**
 * leetcode
 * 2020/10/24 22:03
 * 视频拼接
 *
 * @author Frozen Chan
 * @since
 **/
public class Medium_1024 {
    // 动态规划
    public int videoStitching(int[][] clips, int T) {
        int[] dp = new int[T + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i <= T; i ++) {
            for (int[] clip : clips) {
                if (clip[0] < i && clip[1] >= i) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[T] == Integer.MAX_VALUE - 1 ? -1 : dp[T];
    }

    // 贪心 最优解法
    public int videoStitching2(int[][] clips, int T) {
        int[] maxStep = new int[T];
        for (int[] clip : clips) {
            if (clip[0] < T) {
                maxStep[clip[0]] = Math.max(maxStep[clip[0]], clip[1]);
            }
        }
        int res = 0, last = 0, pre = 0;
        for (int i = 0; i < T; i ++) {
            last = Math.max(last, maxStep[i]);
            if (i == last) {
                return -1;
            }
            if (i == pre) {
                res ++;
                pre = last;
            }
        }
        return res;
    }
}
