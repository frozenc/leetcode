package leetcode.Array;

import java.util.HashMap;
import java.util.Map;

//连续的子数组和
public class Medium_523 {
    //暴力法，双重循环寻找
    public boolean checkSubarraySum(int[] nums, int k) {
        for (int i=0; i<nums.length - 1; i++) {
            int sum = nums[i];
            int left = i+1;
            while (left < nums.length) {
                sum += nums[left];
                if (k == 0 && sum == k) return true;
                if (sum == k || (k!=0 && sum % k == 0)) return true;
                left ++;
            }
        }
        return false;
    }
    //哈希表
    public boolean checkSubarraySum2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        //增加伪元素，处理元素开头为0的情况
        map.put(0,-1);
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum %= k;
            }
            if (map.containsKey(sum)) {
                //只要存在key，就不执行else，不更改map，值
                if (i-map.get(sum) > 1) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}
