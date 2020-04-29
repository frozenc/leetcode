package leetcode.DP;

//最长上升子序列
public class Medium_300 {
    //DP
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n==0) return 0;
        int[] count = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            count[i] = 1;
            for (int j=0; j<i; j++) {
                if (nums[j] < nums[i]) {
                    count[i] = Math.max(count[i], count[j]+1);
                }
            }
            max = Math.max(max, count[i]);
        }
        return max;
    }

    //贪心+二分查找，使用一个数组记录当前n位上升子序列的结尾的最小值
    public int lengthOfLIS2(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;

        int[] tail = new int[len];
        tail[0] = nums[0];
        int end = 0;

        for (int i=1; i<len; i++) {
            if (nums[i] > tail[end]) {
                tail[++end] = nums[i];
            } else {
                //二分查找，找到刚好大于等于nums[i]的位置
                int left = 0, right = end;
                while (left < right) {
                    int mid = left + (right-left)/2;
                    if (tail[mid] < nums[i]) {
                        left = mid+1;
                    } else {
                        right = mid;
                    }
                }
                tail[left] = nums[i];
            }
        }
        return end+1;
    }
}
