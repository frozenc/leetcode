package ByteDanceExplore.String;

/**
 * leetcode
 * 2020/12/31 21:24
 * 字符串的排列，字符串S2是否包含字符串S1的排列
 *
 * @author Frozen Chan
 * @since
 **/
public class CheckInclusion {
    /**
     * 方法一：暴力，计算每个子串的排列，判断是否相等
     * 方法二：排序，计算每个子串排序后的结果是否与S1排序后结果相等
     * 方法三：哈希表，计算每个子串的字符的频率是否与S1相同
     * 方法四：使用数组，思想同方法三
     * 方法五：每次找子串的时候不生成新的数组，而是直接在原数组上操作，滑动窗口
     * 方法六：优化的滑动窗口，计算更新的字符是否匹配
     */
    // 方法五
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i ++) {
            s1map[s1.charAt(i) - 'a'] ++;
            s2map[s2.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i ++) {
            if (matches(s1map, s2map)) {
                return true;
            }
            s2map[s2.charAt(i + s1.length()) - 'a'] ++;
            s2map[s2.charAt(i) - 'a'] --;
        }
        return matches(s1map, s2map);
    }

    public boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i ++) {
            if (s1map[i] != s2map[i]) {
                return false;
            }
        }
        return true;
    }
}
