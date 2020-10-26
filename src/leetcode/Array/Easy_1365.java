package leetcode.Array;

/**
 * leetcode
 * 2020/10/26 18:53
 * 小于当前数字的数量
 *
 * @author Frozen Chan
 * @since
 **/
public class Easy_1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        int n = nums.length;
        for (int i = 0; i < n; i ++) {
            count[nums[i]] ++;
        }
        for (int i = 1; i < 101; i ++) {
            count[i] += count[i - 1];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i ++) {
            res[i] = nums[i] == 0 ? 0 : count[nums[i] - 1];
        }
        return res;
    }
}
