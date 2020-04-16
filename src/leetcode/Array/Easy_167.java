package leetcode.Array;

//两数之和
public class Easy_167 {
    //双指针,时间复杂度为O(n)
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) return new int[] {left+1, right+1};
            if (numbers[left] + numbers[right] > target) {
                right --;
            }
            if (numbers[left] + numbers[right] < target) {
                left ++;
            }
        }
        return null;
    }
}
