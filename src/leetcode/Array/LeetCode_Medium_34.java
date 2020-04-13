package leetcode.Array;

public class LeetCode_Medium_34 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int start, end;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(target == nums[mid]) {
                return getStartEnd(nums, mid);
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    public int[] getStartEnd(int[] nums, int mid) {
        int start = mid, end = mid;
        while (start - 1 >= 0 && nums [start-1] == nums[mid]) {
            start -= 1;
        }
        while (end + 1 < nums.length && nums[end+1] == nums[mid]) {
            end += 1;
        }
        return new int[]{start, end};
    }
}
