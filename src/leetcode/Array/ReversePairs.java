package leetcode.Array;

//查找逆序对
public class ReversePairs {
    //归并排序，暴力法会超时
    public int reversePairs(int[] nums) {
        if (nums.length < 2) return 0;
        int[] copy = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            copy[i] = nums[i];
        }
        int[] temp = new int[nums.length];
        return reversePairs(copy, 0, nums.length-1, temp);
    }
    //nums[left..right] 计算逆序对个数并且排序
    public int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) return 0;
        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid+1, right, temp);

        if (nums[mid] <= nums[mid+1]) {
            return leftPairs + rightPairs;
        }
        int mergeCount = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + mergeCount;
    }
    //nums[left..mid] 有序，nums[mid + 1..right] 有序
    public int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {

        for (int i=left; i<=right; i++) {
            temp[i] = nums[i];
        }
        int i=left, j=mid+1;
        int count = 0;
        for (int k=left; k<=right; k++) {
            if (i==mid+1) {
                nums[k] = temp[j++];
            } else if (j==right+1) {
                nums[k] = temp[i++];
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            } else if (temp[i] > temp[j]) {
                nums[k] = temp[j++];
                count += mid-i+1;
            }
        }
        return count;
    }
}
