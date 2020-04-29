package leetcode.DP;

//爬楼梯
public class Easy_70 {
    //动态规划，爬到第n级楼梯有两个方法，首先爬到n-1再往上爬1级，或者爬到n-2再往上爬2级
    public int climbStairs(int n) {
        int[] nums = new int[n+1];
        nums[1] = 1;
        if (n>1) {
            nums[2] = 2;
            for (int i=3; i<=n; i++) {
                nums[i] = nums[i-1] + nums[i-2];
            }
        }
        return nums[n];
    }
}
