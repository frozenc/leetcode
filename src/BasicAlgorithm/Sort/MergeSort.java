package BasicAlgorithm.Sort;

//归并排序
public class MergeSort {
    public int[] MergeSortRoot(int[] nums) {
        MergeSort(0, nums.length-1, nums);
        return nums;
    }

    public void MergeSort(int left, int right, int[] nums) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            MergeSort(left, mid, nums);
            MergeSort(mid + 1, right, nums);
            Merge(left, mid, right, nums);
        }
    }

    public void Merge(int left, int mid, int right, int[] nums) {
        int[] temp = new int[nums.length];
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while(i <= mid) {
            temp[k++] = nums[i++];
        }
        while(j <= right) {
            temp[k++] = nums[j++];
        }
        for (k=left; k<=right; k++) {
            nums[k] = temp[k];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,4,3,2,1};
        int[] res = new MergeSort().MergeSortRoot(nums);
        for (int num:res) {
            System.out.print(num + "-");
        }
    }
}
