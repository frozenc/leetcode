package leetcode.Array;

//跳跃游戏2
public class Hard_45 {
    //从后面往前跳，找到能跳最远的，时间复杂度O(n^2)
    public int jump(int[] nums) {
        int position = nums.length-1;
        int step = 0;
        while (position > 0) {
            for (int i=0; i<nums.length; i++) {
                if (nums[i] + i >= position) {
                    position = i;
                    step ++;
                    break;
                }
            }
        }
        return step;
    }
    //从前往后跳，时间复杂度O(n)
    public int jump2(int[] nums) {
        //当前能跳到的最远位置
        int maxPosition = 0;
        //记录步数
        int step = 0;
        //end记录边界
        int end = 0;
        for (int i=0; i<nums.length-1; i++) {
            maxPosition = Math.max(maxPosition, nums[i]+i);
            if (i == end) {
                end = maxPosition;
                step ++;
            }
        }
        return step;
    }
}
