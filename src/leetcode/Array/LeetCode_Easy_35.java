package leetcode.Array;

public class LeetCode_Easy_35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) { //查找元素在左边
                right = mid-1;
            } else { //查找元素在右边
                left = mid+1;
            }
        }
        return left;
    }
}
