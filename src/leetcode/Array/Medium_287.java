package leetcode.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//查找重复数
public class Medium_287 {
    //集合法
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i:nums) {
            if (set.contains(i)) {
                return i;
            }
            set.add(i);
        }
        return 0;
    }
    //排序找重复元素
    public int findDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return nums[i];
            }
        }
        return -1;
    }
    //二分法，时间复杂度为N*logN
    public int findDuplicate3(int[] nums) {
        int left = 0, right = nums.length-1;
        int count = 0;
        while (left < right) {
            int mid = left + (right - left)/2;
            count = 0;
            for (int i:nums) {
                if (i<=mid) count ++;
            }
            if (count <= mid) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
