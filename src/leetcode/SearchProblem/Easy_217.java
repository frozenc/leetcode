package leetcode.SearchProblem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//存在重复元素
public class Easy_217 {
    //哈希set实现
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i:nums) {
            if (set.contains(i)) return true;
            set.add(i);
        }
        return false;
    }
    //排序后查找
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == nums[i-1]) return true;
        }
        return false;
    }
}
