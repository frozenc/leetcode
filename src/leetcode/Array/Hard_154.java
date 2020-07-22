package leetcode.Array;

//旋转数组的最小数
public class Hard_154 {
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length-1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            //右半边递增，最小数在左侧
            if (numbers[mid] < numbers[right]) {
                right = mid;
            } else if (numbers[mid] > numbers[right]){
                //右半边不是递增，最小数在右边
                left = mid + 1;
            } else {
                right -= 1;
            }
        }
        return numbers[left];
    }
}
