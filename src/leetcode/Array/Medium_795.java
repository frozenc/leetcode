package leetcode.Array;

//区间子数组个数
public class Medium_795 {
    //合法的组合减去不合法的组合
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        return count(A, R) - count(A, L-1);
    }

    public int count(int[] nums, int right) {
        int cur = 0, sum = 0;
        for (int i:nums) {
            cur = i <= right ? cur+=1: 0;
            sum += cur;
        }
        return sum;
    }
}
