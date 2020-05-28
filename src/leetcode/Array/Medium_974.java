package leetcode.Array;

import java.util.HashMap;
import java.util.Map;

//和可被K整除的子数组
public class Medium_974 {
    //哈希表逐一统计
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        int sum = 0, res = 0;
        for (int num:A) {
            sum += num;
            int temp = (sum % K + K) % K;
            int same = map.getOrDefault(temp, 0);
            res += same;
            map.put(temp, same + 1);
        }
        return res;
    }
    //利用排列组合的思想
    public int subarraysDivByK2(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        int sum = 0, res = 0;
        for (int num:A) {
            sum += num;
            int temp = (sum % K + K) % K;
            int same = map.getOrDefault(temp, 0);
            map.put(temp, same + 1);
        }
        for (int num:map.values()) {
            res += num * (num-1) / 2;
        }
        return res;
    }
}
