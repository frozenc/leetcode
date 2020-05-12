package leetcode.Array;

import java.util.Arrays;

//最长连续序列
public class Hard_128 {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int count = 1;
        int max = 1;
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i+1] - nums[i] == 1) {
                count ++;
                max = Math.max(count, max);
            } else if (nums[i+1] == nums[i]) {
                continue;
            } else {
                count = 1;
            }
        }
        return max;
    }
}
