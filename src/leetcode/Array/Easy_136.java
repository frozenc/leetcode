package leetcode.Array;

import java.util.HashSet;
import java.util.Set;

//寻找只出现过一次的数字
public class Easy_136 {
    public int singleNumber(int[] nums) {
        //异或方法，两个数相同，异或结果为0，异或具有交换性
        int a = 0;
        for (int i=0; i<nums.length; i++) {
            a ^= nums[i];
        }
        return a;
    }

    public int singleNumber2(int[] nums) {
        //数学方法 2*(a+b+c) - (a+b+c+a+b) = c
        Set<Integer> set =  new HashSet<>();
        int sumOfArray = 0;
        int sumOfSet = 0;
        for (int i:nums) {
            if (!set.contains(i)) {
                set.add(i);
                sumOfSet += i;
            }
            sumOfArray += i;
        }
        return 2 * sumOfSet - sumOfArray;
    }
}
