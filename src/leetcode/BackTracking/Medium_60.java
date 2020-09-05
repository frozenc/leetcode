package leetcode.BackTracking;

import java.util.Arrays;

/**
 * leetcode
 * 2020/9/5 14:27
 * 第k个排列
 *
 * @author Chan
 **/
public class Medium_60 {
    //找规律
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n+1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i-1] * i;
        }

        k--;
        StringBuilder res = new StringBuilder();
        int[] valid = new int[n+1];
        Arrays.fill(valid, 1);
        for (int i = 1; i <= n; i++) {
            int order = k / factorial[n - i] + 1;
            for (int j = 1; j <= n; j++) {
                order -= valid[j];
                if (order == 0) {
                    res.append(j);
                    valid[j] = 0;
                    break;
                }
            }
            k %= factorial[n - i];
        }
        return res.toString();
    }
}
