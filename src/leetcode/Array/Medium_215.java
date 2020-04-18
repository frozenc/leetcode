package leetcode.Array;

import java.util.PriorityQueue;

//topK问题
public class Medium_215 {
    //使用BFPRT算法，是快速排序改进版，计算中位数，具体实现见util包
    //借助小顶堆实现
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1,n2)->n1-n2);
        for (int i:nums) {
            heap.add(i);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }
    //使用快速排序实现
    public int findKthLargest2(int[] nums, int k) {
        return quickSort(nums, 0, nums.length-1, nums.length-k);
    }

    public int quickSort(int[] nums, int left, int right, int k) {
        int p = partion(nums, left, right);
        if (p==k) return nums[p];
        if (p>k) return quickSort(nums, left, p, k);
        return quickSort(nums, p+1, right, k);
    }

    public int partion(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i =left, j = right;
        while (i < j) {
            while (nums[j] >= pivot && i<j) {
                j--;
            }
            nums[i] = nums[j];
            while (nums[i] <= pivot && i<j) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        System.out.println(i);
        return i;
    }

    public static void main(String[] args) {
//        int[] nums = {50,40,10,20,60,30,70,90,80};
        int[] nums = {3,2,3,1,2,4,5,5,6};
        new Medium_215().findKthLargest2(nums, 4);
    }
}
