package leetcode.Array;

import java.util.Arrays;
import java.util.Stack;

//最短无序连续子数组
public class Easy_581 {
    //先排序，后比较
    public int findUnsortedSubarray(int[] nums) {
        int[] clone_nums = nums.clone();
        int start = nums.length, end = 0;
        Arrays.sort(nums);
        for (int i=0; i<nums.length;i++) {
            if (nums[i]!=clone_nums[i]) {
                start = Math.min(start,i);
                end = Math.max(end,i);
            }
        }
        return end-start>0?end-start+1:0;
    }
    //查找无序数组的最大最小值，查找其应该出现的位置
    public int findUnsortedSubarray2(int[] nums) {
        int start = nums.length, end = 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i+1] < nums[i]) {
                min = Math.min(nums[i+1],min);
                max = Math.max(nums[i],max);
            }
        }
        for (int i=0; i<nums.length; i++) {
            if (nums[i]>min) {
                start = i;
                break;
            }
        }
        for (int i=nums.length-1; i>=0; i--) {
            if (nums[i]<max) {
                end = i;
                break;
            }
        }
        return end-start>0?end-start+1:0;
    }
    //用栈实现，查找无序最大最小
    public int findUnsortedSubarray3(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int start = nums.length, end = 0;
        for (int i=0; i<nums.length; i++) {
            while(!stack.isEmpty() && nums[stack.peek()]>nums[i]) {
                start = Math.min(start, stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        for (int i=nums.length-1; i>=0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()]<nums[i]) {
                end = Math.max(end,stack.pop());
            }
            stack.push(i);
        }
        return end-start>0?end-start+1:0;
    }
    //优化后的暴力法
    public int findUnsortedSubarray4(int[] nums) {
        int start = nums.length, end = 0;
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[j] < nums[i]) {
                    start = Math.min(start,i);
                    end = Math.max(end,j);
                }
            }
        }
        return end>start?end-start+1:0;
    }
    //暴力法，时间复杂度O(n^2)
    public int findUnsortedSubarray5(int[] nums) {
        int start = 0, end = 0;
        boolean flag = false;
        for (int i=0; i<nums.length; i++) {
            for (int j=i; j<nums.length; j++) {
                if (nums[j] < nums[i]) {
                    start = i;
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
        flag = false;
        for (int i=nums.length-1; i>=0; i--) {
            for (int j=i; j>=0; j--) {
                if (nums[j] > nums[i]) {
                    end = i;
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
        return end>start?end-start+1:0;
    }
}
