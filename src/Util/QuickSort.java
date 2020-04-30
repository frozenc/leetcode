package Util;

public class QuickSort {
    public int partion(int[] nums, int left, int right) {
        int i = left, j = right;
        int pivot = nums[left];
        while ( i<j ) {
            while (nums[j] >= pivot && i<j) {
                j--;
            }
            nums[i] = nums[j];
            while (nums[i] <= pivot && i<j) {
                i ++;
            }
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        return i;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int k = partion(nums, left, right);
            quickSort(nums, left, k);
            quickSort(nums, k+1, right);
        }
    }

    public static void main(String[] args) {
        int[] nums = {50,40,20,10,80,30,70,90};
        new QuickSort().quickSort(nums, 0, nums.length-1);
        for(int i:nums) {
            System.out.println(i);
        }
    }
}
