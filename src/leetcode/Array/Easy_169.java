package leetcode.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//找出多数元素
public class Easy_169 {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i:nums) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int max = 0;
        int index = 0;
        for (int i:map.keySet()) {
            if (map.get(i) >= max) {
                max = map.get(i);
                index = i;
            }
        }
        return index;
    }

    //先排序再操作
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
