package leetcode.Array;

import java.util.Arrays;

//转换数组后最接近目标值的数组和
public class Medium_1300 {
    //方法1 枚举法+二分
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int len = arr.length;
        int[] prefix = new int[len+1];
        //差异最大为target，全为0
        int diff = target;
        int res = 0;
        for (int i=1; i<=len; i++) {
            //预处理前n项和
            prefix[i] = prefix[i-1] + arr[i-1];
        }
        int right = arr[arr.length-1];
        for (int i=1; i<=right; i++) {
            int index = Arrays.binarySearch(arr, i);
            if (index < 0) {
                //当二分法找不到元素时，返回-（low+1)
                index = -index-1;
            }
            int sum = prefix[index] + (len-index) * i;
            if (Math.abs(target - sum) < diff) {
                res = i;
                diff = Math.abs(target - sum);
            }
        }
        return res;
    }

    public int findBestValue2(int[] arr, int target) {
        Arrays.sort(arr);
        int len = arr.length;
        int[] prefix = new int[len+1];
        for (int i=1; i<=len; i++) {
            //预处理前n项和
            prefix[i] = prefix[i-1] + arr[i-1];
        }
        int left = 0, right = arr[len-1], res = -1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int index = Arrays.binarySearch(arr, mid);
            if (index < 0) {
                index = - index - 1;
            }
            int cur = prefix[index] + (len - index) * mid;
            //找到第一个总和大于target的数
            if (cur <= target) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int sum1 = check(arr, res);
        int sum2 = check(arr, res + 1);
        return Math.abs(sum1 - target) <= Math.abs(sum2 - target) ? res : res + 1;
    }

    public int check(int[] arr, int res) {
        int sum = 0;
        for (int num:arr) {
            sum += Math.min(num, res);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,9};
        System.out.println(new Medium_1300().findBestValue2(arr, 10));
    }
}
