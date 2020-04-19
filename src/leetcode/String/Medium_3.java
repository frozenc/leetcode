package leetcode.String;

import java.util.HashSet;
import java.util.Set;

//无重复字符的最大子串
public class Medium_3 {
    //滑动窗口法
    public int lengthOfLongestSubstring(String s) {
        // if (s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, max = 0;
        while (right < s.length()) {
            char c1 = s.charAt(right);
            while (left<right && set.contains(c1)) {
                set.remove(s.charAt(left++));
            }
            set.add(c1);
            max = Math.max(set.size(), max);
            right ++;
        }
        return max;
    }
}
