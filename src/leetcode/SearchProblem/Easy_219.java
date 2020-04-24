package leetcode.SearchProblem;

import java.util.HashMap;
import java.util.Map;

//存在重复元素2
public class Easy_219 {
    //通过哈希表实现，记录元素下标，只要存在即可
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i]) && i-map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
