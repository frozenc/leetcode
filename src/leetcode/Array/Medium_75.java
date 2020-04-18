package leetcode.Array;

//颜色分类，数组排序
public class Medium_75 {
    //三指针扫描交换元素，更优雅的做法
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length-1, cur = 0;
        while (cur <= right) {
            if (nums[cur] == 0) {
                swap(nums, cur, left);
                left ++;
                cur ++;
            } else if (nums[cur] == 1) {
                cur ++;
            } else {
                swap(nums, cur, right);
                right --;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //两遍扫描，第一次统计元素，第二次重写数组
    public void sortColors2(int[] nums) {
        int red = 0, white = 0, blue = 0;
        for (int i:nums) {
            switch(i) {
                case (0):
                    red += 1;
                    break;
                case(1):
                    white += 1;
                case(2):
                    blue += 1;
            }
        }
        for (int i=0; i<nums.length; i++) {
            if (i<red) {
                nums[i] = 0;
            } else if (i<red+white) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}
