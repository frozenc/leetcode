package leetcode.DP;

//打家劫舍
public class Easy_198 {
    //比较前n-2家的总金额加上第n家是否大于前n-1家金额
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        if (nums.length > 1) {
            sum[1] = Math.max(nums[0], nums[1]);
            for (int i=2; i<nums.length; i++) {
                sum[i] = Math.max(sum[i-2] + nums[i], sum[i-1]);
            }
        }
        return sum[nums.length-1];
    }
}
