package leetcode.Array;

/**
 * leetcode
 * 2020/10/25 10:28
 * 最长山脉
 *
 * @author Frozen Chan
 * @since
 **/
public class Medium_845 {
    //枚举方法
    public int longestMountain(int[] A) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        int[] left = new int[n];
        for (int i = 1; i < n - 1; i ++) {
            left[i] = A[i - 1] < A[i] ? left[i-1] + 1 : 0;
        }
        int[] right = new int[n];
        for (int i = n - 2; i >= 0; i --) {
            right[i] = A[i + 1] < A[i] ? right[i+1] + 1 : 0;
        }
        int ans = 0;
        for (int i = 0; i < n; i ++) {
            if (left[i] > 0 && right[i] > 0) {
                ans = Math.max(ans, left[i] + right[i] + 1);
            }
        }
        return ans;
    }

    //双指针方法
    public int longestMountain2(int[] A) {
        int n = A.length;
        int ans = 0, left = 0;
        while (left + 2 < n) {
            int right = left + 1;
            if (A[left] < A[right]) {
                while (right + 1 < n && A[right] < A[right + 1]) {
                    ++ right;
                }
                if (right + 1 < n && A[right] > A[right + 1]) {
                    while (right + 1 < n && A[right] > A[right + 1]) {
                        ++ right;
                    }
                    ans = Math.max(ans, right - left + 1);
                } else {
                    ++ right;
                }
            }
            left = right;
        }
        return ans;
    }


}
