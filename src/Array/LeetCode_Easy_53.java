package Array;

//最大子序和
public class LeetCode_Easy_53 {
    public int maxSubArray(int[] nums) {
        int curSum = nums[0], max = nums[0];
        for (int i=1; i<nums.length; i++) {
            //判断前面的和是否为正数，不是则重新累加
            curSum = Math.max(nums[i], nums[i]+curSum);
            max = Math.max(curSum, max);
        }
        return max;
    }
}
