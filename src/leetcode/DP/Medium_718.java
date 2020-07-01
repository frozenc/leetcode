package leetcode.DP;

//最长重复子数组
public class Medium_718 {
    //dp做法
    public int findLength(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int[][] dp = new int[m+1][n+1];
        int res = 0;
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (A[i-1] == B[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
    //滑动窗口做法
    public int findLength2(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int res = 0;
        for (int i=0; i<m; i++) {
            int len = Math.min(n, m-i);
            res = Math.max(res, maxLength(A, B, i, 0, len));
        }
        for (int i=0; i<n; i++) {
            int len = Math.min(m, n-i);
            res = Math.max(res, maxLength(A, B, 0, i, len));
        }
        return res;
    }

    public int maxLength(int[] A, int[] B, int i, int j, int length) {
        int res = 0, len = 0;
        for (int k=0; k<length; k++) {
            if (A[i + k] == B[j + k]) {
                len ++;
            } else {
                len = 0;
            }
            res = Math.max(res, len);
        }
        return res;
    }
}
