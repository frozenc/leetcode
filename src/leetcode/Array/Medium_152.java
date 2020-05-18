package leetcode.Array;

//最大乘积数组
public class Medium_152 {
    //与最大和连续数组类似
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for(int i=1; i<nums.length; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);

            res = Math.max(res, max);
        }
        return res;
    }
}
