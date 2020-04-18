package leetcode.Array;

//跳跃游戏
public class Medium_55 {
    //一直往前跳，直到能跳出边界
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i=0; i<nums.length; i++) {
            //判断是否停滞不前，停留在某个点
            if (i<=max) {
                max = Math.max(max, i+nums[i]);
                if (max >= nums.length-1) {
                    return true;
                }
            }

        }
        return false;
    }
}
