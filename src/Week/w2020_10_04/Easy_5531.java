package Week.w2020_10_04;

/**
 * leetcode
 * 2020/10/4 11:55
 * 特殊数组的特殊值
 *
 * @author Frozen Chan
 * @since
 **/
public class Easy_5531 {
    public int specialArray(int[] nums) {
        int len = nums.length;
        int count = 0;
        for (int j = 1; j <= len; j++) {
            for (int num : nums) {
                if (num >= j) {
                    count ++;
                }
            }
            if (count == j) {
                return j;
            }
            count = 0;
        }

        return -1;
    }
}
