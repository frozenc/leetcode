package leetcode.Array;

import java.util.Arrays;

/**
 * leetcode
 * 2020/11/26 11:42
 * 最大间隔
 *
 * @author Frozen Chan
 * @since
 **/
public class Hard_164 {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        int minVal = Arrays.stream(nums).min().getAsInt();
        int maxVal = Arrays.stream(nums).max().getAsInt();
        int d = Math.max(1, (maxVal - minVal) / (n - 1));
        int bucketSize = (maxVal - minVal) / d + 1;
        int[][] buckets = new int[bucketSize][2];
        for (int i = 0; i < bucketSize; i ++) {
            Arrays.fill(buckets[i], -1);
        }

        for (int i = 0; i < n; i ++) {
            int index = (nums[i] - minVal) / d;
            if (buckets[index][0] == -1) {
                buckets[index][0] = buckets[index][1] =  nums[i];
            } else {
                buckets[index][0] = Math.min(buckets[index][0], nums[i]);
                buckets[index][1] = Math.max(buckets[index][1], nums[i]);
            }
        }

        int ret = 0;
        int pre = -1;
        for (int i = 0; i < bucketSize; i ++) {
            if (buckets[i][0] == -1) {
                continue;
            }
            // System.out.println(buckets[i][0] - buckets[i-1][1]);
            if (pre != -1) {
                ret = Math.max(buckets[i][0] - buckets[pre][1], ret);
            }
            pre = i;
        }
        return ret;
    }
}
