package BasicAlgorithm.Sort;

//快排
public class QuickSort {
    public int[] QuickSort(int[] nums) {
        QuickSort(0, nums.length-1, nums);
        return nums;
    }

    public void QuickSort(int left, int right, int[] nums) {
        if (left < right) {
            int pivot = Partition(left, right, nums);
            QuickSort(left, pivot-1, nums);
            QuickSort(pivot+1, right, nums);
        }
    }

    public int Partition(int left, int right, int[] nums) {
        int target = nums[right];
        int i = left;
        for (int j = left; j<=right; j++) {
            if (nums[j] < target) {
                swap(j, i, nums);
                i ++;
            }
        }
        swap(i, right, nums);
        return i;
    }

    public void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,4,3,2,1};
        nums = new QuickSort().QuickSort(nums);
        for (int num:nums) {
            System.out.print(num + "-");
        }
    }
}
