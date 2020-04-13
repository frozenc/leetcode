package leetcode.Array;

public class LeetCode_Medium_33 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                //345612，左边是有序的
                if (nums[left] <= target && target <= nums[mid]) {
                    //目标在有序的左边
                    right = mid-1;
                } else {
                    //目标在无序的右边
                    left = mid+1;
                }
            } else {
                //6712345,右边是有序的
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,4,5,6,1,2};
        System.out.println(new LeetCode_Medium_33().search(nums, 1));
    }
}
