package leetcode.Array;

//优美数组
public class Medium__1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length, sum = 0, count = 0, arr[] = new int[len+2];
        //数组存放的是奇数所在的下标
        for (int i=0; i<len; i++) {
            if (nums[i]%2 == 1) {
                arr[++count] = i;
                // System.out.println(arr[count]);
            }
        }
        arr[0] = -1;
        arr[++count] = len;
        for (int i=1; i+k<count+1; i++) {
            sum += (arr[i]-arr[i-1]) * (arr[i+k] - arr[i+k-1]);
        }
        return sum;
    }
}
