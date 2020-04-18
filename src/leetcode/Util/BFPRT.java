package leetcode.Util;


public class BFPRT {
    public void insertSort(int[] nums, int left, int right) {
        for (int i=left + 1; i<=right; i++) {
            if (nums[i] < nums[i-1]) {
                int temp = nums[i];
                int j = i;
                //所有大于当前插入元素的都往后移
                while (j>left && nums[j-1] > temp) {
                    nums[j] = nums[j-1];
                    j--;
                }
                nums[j] = temp;
            }
        }
    }

    public int findMiddle(int[] nums, int left, int right) {
        if (left == right) return left;
        int i=0, n=0;
        for (i=left; i<right-5; i+=5) {
            insertSort(nums, i, i+4);
            n = i-left;
            swap(nums, left + n/5, i+2);
        }
        int num = right - i + 1;
        insertSort(nums, i, right);
        n = i-left;
        swap(nums, left + n/5, i+num/2);
        n /= 5;
        return findMiddle(nums, left, left + n);
    }

    public int partion(int[] nums, int left, int right, int mid) {
        swap(nums, left, mid);
        int i = left, j = right;
        int pivot = nums[left];
        while (i<j) {
            while (nums[j] > pivot && i<j) {
                j--;
            }
            nums[i] = nums[j];
            while (nums[i] < pivot && i<j) {
                i ++;
            }
            nums[j] = nums[j];
        }
        nums[i] = pivot;
        return i;
    }

    public int bfprt(int[] nums, int left, int right, int k) {
        int mid = findMiddle(nums, left, right);
        int p = partion(nums, left, right, mid);
        if (p == nums.length-k) return nums[p];
        if (p > nums.length-k) return bfprt(nums, left, p-1, k);
        return bfprt(nums, p+1, right, k);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {50,40,20,10,70,30,90,80};
        System.out.println(new BFPRT().bfprt(nums, 0, nums.length-1, 1));
    }
}
