package leetcode.Interview;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//数组中数字出现的次数
public class Medium_Interview_56 {
    //哈希set，不满足时间复杂度O(n),空间复杂度O(1)
    public int[] singleNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num:nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }

        }
        int[] res = new int[set.size()];
        int i=0;
        for (int num:set) {
            res[i++] = num;
        }
        return res;
    }

    //分组异或思路
    public int[] singleNumbers2(int[] nums) {
        int res = 0, index = 0;
        //全部数字异或结果，结果为俩不重复数字的异或
        for (int num:nums) {
            res ^= num;
        }
        //找到异或数字不相等的位置
        while ((res & 1) == 0) {
            index ++;
            res >>= 1;
        }
        int r1 = 0, r2 = 0;
        //根据上述位置对数字分成两组，两组分别异或，剩下的即为结果
        for (int num:nums) {
            if (((num >> index) & 1) == 0) {
                r1 ^= num;
            } else {
                r2 ^= num;
            }
        }
        return new int[]{r1, r2};
    }
}
