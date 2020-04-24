package leetcode.SearchProblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//两个数组的交集2
public class Easy_350 {
    //排序+双指针法
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] res = new int[nums1.length];
        int idx = 0, ptr1 = 0, ptr2 = 0;
        while (ptr1 < nums1.length && ptr2 < nums2.length) {
            if (nums1[ptr1] == nums2[ptr2]) {
                res[idx++] = nums1[ptr1];
                ptr1 ++;
                ptr2 ++;
            } else if (nums1[ptr1] < nums2[ptr2]) {
                ptr1 ++;
            } else if (nums1[ptr1] > nums2[ptr2]) {
                ptr2 ++;
            }
        }

        return Arrays.copyOf(res, idx);
    }
    //哈希map映射记录出现次数
    public int[] intersect2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];
        int idx = 0;

        for (int i:nums1) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        for (int i:nums2) {
            int count = map.getOrDefault(i, 0);
            if (count > 0) {
                res[idx++] = i;
                map.put(i,map.get(i)-1);
            }
        }

        return Arrays.copyOf(res, idx);
    }
}
