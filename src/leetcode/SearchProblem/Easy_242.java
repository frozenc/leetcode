package leetcode.SearchProblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//有效的字母异位词
public class Easy_242 {
    //通过哈希map记录字符出现次数实现
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int j=0; j<t.length(); j++) {
            char c = t.charAt(j);
            int cnt = map.getOrDefault(c, 0);
            if (cnt == 0) {
                return false;
            } else {
                map.put(c, map.get(c)-1);
            }
        }
        for (char c:map.keySet()) {
            if (map.get(c) > 0) return false;
        }
        return true;
    }

    //字母计数表高效实现
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] cnt = new int[26];
        for (int i=0; i<s.length(); i++) {
            cnt[s.charAt(i) - 'a'] ++;
        }
        for (int j=0; j<t.length(); j++) {
            cnt[t.charAt(j) - 'a'] --;
            if (cnt[t.charAt(j) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    //排序比较字符数组是否相同
    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }
}
