package leetcode.Array;

//移动0
public class Easy_283 {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int j=0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                if (i>j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j ++;
            }
        }
    }
}
