package ByteDanceExplore.String;

import java.util.HashMap;

/**
 * leetcode
 * 2020/12/31 20:12
 * 无重复字符的最长子串
 *
 * @author Frozen Chan
 * @since
 **/
public class LengthOfLongestSubstring {
    // 哈希表+动态规划
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len = s.length();
        int tmp = 0, res = 0;
        for (int i = 0; i < len; i ++) {
            char c = s.charAt(i);
            int j = map.getOrDefault(c, -1);
            map.put(c, i);
            //如果tmp > i - j, 说明i与j之间无重复字符，需重新计算不重复字符串，否则tmp继续累加，i与j之间已经有重复字符
            tmp = tmp < i - j ? tmp + 1 : i - j;
            res = Math.max(res, tmp);
        }
        return res;
    }

    //双指针+哈希表
    public int lengthOfLongestSubstring2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len = s.length();
        int j = -1, res = 0;
        for (int i = 0; i < len; i ++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                j = Math.max(j, map.get(c));
            }
            map.put(c, i);
            res = Math.max(res, i - j);
        }
        return res;
    }

    //双指针+动态规划
    public int lengthOfLongestSubstring3(String s) {
        int len = s.length();
        int tmp = 0, res = 0;
        for (int i = 0; i < len; i ++) {
            char c = s.charAt(i);
            int j = i - 1;
            while (j >= 0 && s.charAt(j) != c) -- j;
            tmp = tmp < i - j ? tmp + 1 : i - j;
            res = Math.max(tmp, res);
        }
        return res;
    }
}
