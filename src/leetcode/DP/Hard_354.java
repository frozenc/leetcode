package leetcode.DP;

import java.util.Arrays;
import java.util.Comparator;

/**
 * leetcode
 * 俄罗斯套娃信封
 *
 * @author Chan
 * @since 2021/3/4 11:15
 **/
public class Hard_354 {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o2[1] - o1[1];
                }
            }
        });

        int[] dp = new int[n];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < i; j ++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        // [[1,2],[2,3],[3,4],[4,5],[5,6],[5,5],[6,7],[7,8]]
        int[][] input = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {5, 5}, {6, 7}, {7, 8}};
        new Hard_354().maxEnvelopes(input);
    }
}
