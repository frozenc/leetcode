package leetcode.SearchProblem;

import java.util.HashMap;
import java.util.Map;

//两数之和
public class Easy_1 {
    //通过哈希表记录之前查找过的数字
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            int complements = target - nums[i];
            if (map.containsKey(complements)) {
                return new int[]{map.get(complements), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
