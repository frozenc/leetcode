package leetcode.Array;

import java.util.*;

public class Easy_448 {
    //原地修改，没有被改到的位置就是大于0，就是消失的数字
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        List<Integer> list = new LinkedList<>();
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i+1);
            }
        }
        return list;
    }

    //哈希set实现
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i:nums) {
            if (!set.contains(i)){
                set.add(i);
            }
        }
        List<Integer> res = new LinkedList<>();
        for (int i=1; i<=nums.length; i++) {
            if (!set.contains(i)) {
                res.add(i);
            }
        }
        return res;
    }
}
