package leetcode.Array;

import java.util.Arrays;

//最接近的三数之和
public class Medium_16 {
    //思想与15一样，双指针，最外层套个循环
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[nums.length-1];
        for (int k=0; k<nums.length-2; k++) {
            if (k>0 && nums[k] == nums[k-1]) continue;
            int i=k+1, j=nums.length-1;
            while(i<j) {
                int sum = nums[k] + nums[i] + nums[j];
                int diff = Math.abs(sum - target);
                if (diff < Math.abs(res - target)) {
                    res = sum;
                }
                if (sum < target) {
                    while(i<j && nums[i] == nums[++i]);
                } else if (sum > target) {
                    while (i<j && nums[j] == nums[--j]);
                } else if (sum == target) {
                    return sum;
                }
            }
        }
        return res;
    }
}
