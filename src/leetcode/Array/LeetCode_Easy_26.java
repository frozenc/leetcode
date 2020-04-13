package leetcode.Array;

public class LeetCode_Easy_26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        //慢指针
        int len = 1;
        //快指针
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums [len -1 ]) {
                nums[len++] = nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,4};
        int index = new LeetCode_Easy_26().removeDuplicates(nums);
        System.out.println(index);
    }
}
