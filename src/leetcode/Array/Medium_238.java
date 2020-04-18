package leetcode.Array;

//除自身外的乘积
public class Medium_238 {
    //当前数字结果=左边数字的乘积*右边数字的乘积
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        for (int i=0; i<nums.length; i++) {
            res[i] = k;
            k = k * nums[i];
        }
        k = 1;
        for (int i=nums.length-1; i>=0; i--) {
            res[i] *= k;
            k = k * nums[i];
        }
        return res;
    }
}
