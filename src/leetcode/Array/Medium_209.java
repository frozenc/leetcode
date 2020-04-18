package leetcode.Array;

//长度最小的子数组
public class Medium_209 {
    //双指针法，滑动窗口查找满足的距离
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = nums.length - 1;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            right ++;
            while (sum >= s) {
                min = Math.min(min, right - left);
                left ++;
            }
        }
        return min;
    }
}
