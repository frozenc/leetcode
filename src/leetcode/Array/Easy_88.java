package leetcode.Array;

//合并两个有序数组
public class Easy_88 {
    //从后往前排序，思路简单很多
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = nums1.length-1;
        int i = m-1;
        int j = n-1;
        while ( i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[len--] = nums2[j--];
            } else {
                nums1[len--] = nums1[i--];
            }
        }
        if (i<0) {
            while(j >= 0) {
                nums1[len--] = nums2[j--];
            }
        }
    }
}
