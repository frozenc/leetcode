package leetcode.SearchProblem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//两个数组的交集
public class Easy_349 {
    //利用hashset实现
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i:nums1) set1.add(i);
        Set<Integer> set2 = new HashSet<>();
        for (int i:nums2) set2.add(i);

        int[] res = new int[Math.min(nums1.length, nums2.length)];
        int idx = 0;

        for (int j:set2) {
            if (set1.contains(j)) {
                res[idx++] = j;
            }
        }

        return Arrays.copyOf(res, idx);
    }
    //先排序，双指针实现
    public int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] res = new int[nums1.length];
        Set<Integer> set = new HashSet<>();
        int idx = 0, ptr1 = 0, ptr2 = 0;
        while (ptr1 < nums1.length && ptr2 < nums2.length) {
            if (nums1[ptr1] == nums2[ptr2]) {
                set.add(nums1[ptr1]);
                ptr1 ++;
                ptr2 ++;
            } else if (nums1[ptr1] < nums2[ptr2]) {
                ptr1 ++;
            } else if (nums1[ptr1] > nums2[ptr2]) {
                ptr2 ++;
            }
        }
        for (int i:set) {
            res[idx++] = i;
        }
        return Arrays.copyOf(res, idx);
    }
    //二分法
    public int[] intersection3(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        int[] res = new int[nums1.length];
        Set<Integer> set = new HashSet<>();
        int idx = 0;

        for (int i=0; i<nums2.length; i++) {
            int left = 0, right = nums1.length-1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums1[mid] == nums2[i]) {
                    set.add(nums2[i]);
                    break;
                } else if (nums1[mid] < nums2[i]) {
                    left = mid+1;
                } else if (nums1[mid] > nums2[i]) {
                    right = mid-1;
                }
            }
        }

        for (int i:set) {
            res[idx++] = i;
        }
        return Arrays.copyOf(res, idx);
    }
}
