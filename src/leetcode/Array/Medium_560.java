package leetcode.Array;

import java.util.HashMap;
import java.util.Map;

//和为k的连续子数组
public class Medium_560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int pre = 0;
        map.put(0,1);
        int count = 0;
        int len = nums.length;
        for (int i=0; i<len; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }

        return count;
    }
}
