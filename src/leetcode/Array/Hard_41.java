package leetcode.Array;

import java.util.Arrays;

//缺失的第一位正数
public class Hard_41 {
    //排序 n(logn)不满足题意
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int num = 1;
        for (int i:nums) {
            if (i > 0 && i == num) {
                num ++;
            }
        }
        return num;
    }
    //仿哈希表
    public int firstMissingPositive2(int[] nums) {
        int len = nums.length;
        //给负数打标记
        for (int i=0; i<len; i++) {
            if (nums[i] <= 0) {
                nums[i] = len + 1;
            }
        }
        //给出现的数打上负号标记
        for (int i=0; i<len; i++) {
            int num = Math.abs(nums[i]);
            if (num <= len) {
                nums[num-1] = - Math.abs(nums[num-1]);
            }
        }
        //寻找没有负号的数
        for (int i=0; i<len; i++) {
            if (nums[i] > 0) {
                return i+1;
            }
        }
        return len + 1;
    }
    //两两交换，白嫖原始空间
    public int firstMissingPositive3(int[] nums) {
        int len = nums.length;
        for (int i=0; i<len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i]-1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[temp-1];
                nums[temp-1] = temp;
            }
        }

        for (int i=0; i<len; i++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }
        return len + 1;
    }
}
