package Week.w2020_10_25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode
 * 2020/10/25 12:47
 * 等差子数组
 *
 * @author Frozen Chan
 * @since
 **/
public class Medium_5547 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = l.length;
        List<Boolean> res = new ArrayList<>();

        for (int i = 0; i < n; i ++) {
            int[] sub = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            res.add(isArithmeticProgression(sub));
        }
        return res;
    }

    public boolean isArithmeticProgression(int[] sub) {
        int[] copy = sub.clone();
        Arrays.sort(copy);
        int n = copy.length;
        // for (int i = 0; i < n; i++) {
        //     System.out.println("i" + "-" + copy[i]);
        // }
        int diff = copy[1] - copy[0];
        for (int i = 2; i < n; i++) {
            if (copy[i] - copy[i-1] != diff) {
                return false;
            }
        }
        return true;
    }
}
