package Array;

public class LeetCode_Easy_27 {
    public int removeElement(int[] nums, int val) {
        //还是使用快指针慢指针思路
        if (nums.length == 0) return 0;
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[len++] = nums[i];
            }
        }
        return len;
    }
}
