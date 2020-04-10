package Array;

public class LeetCode_Medium_31 {
    public void nextPermutation(int[] nums) {
        int start = nums.length - 2;
        while (start >= 0 && nums[start] >= nums[start+1]) {
            start --;
        }
        if (start >= 0) {
            int j = nums.length - 1;
            while (j > start && nums[j] <= nums[start]) {
                j --;
            }
            swap(nums, start, j);
        }
        reverse(nums, start+1);
    }

    public void reverse(int[] nums, int i) {
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i ++;
            j --;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,8,4,7,6,5,3,1};
        new LeetCode_Medium_31().nextPermutation(nums);
        for (int i:nums
             ) {
            System.out.print(i);
        }
    }
}
