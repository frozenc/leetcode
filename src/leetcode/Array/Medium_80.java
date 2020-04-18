package leetcode.Array;

//删除数组中的重复项
public class Medium_80 {
    //双指针思路，覆盖重复元素
    public int removeDuplicates(int[] nums) {
        int fast = 1, slow = 1;
        int count = 0;
        while (fast < nums.length) {
            if (nums[fast] == nums[fast-1]) {
                count++;
            } else {
                count = 0;
            }
            if (count < 2) {
                nums[slow++] = nums[fast];
            }
            fast ++;
        }
        return slow;
    }
}
