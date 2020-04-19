package leetcode.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//字母异位词
public class Medium_438 {
    //滑动窗口法，两个hashmap记录，确定符合的有效字符
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> needs = new HashMap<>();
        HashMap<Character, Integer> windows = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        int left = 0, right = 0;
        int index = 0, match = 0;

        for (int i=0; i<p.length(); i++) {
            char c = p.charAt(i);
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        while (right < s.length()) {
            char c = s.charAt(right);
            if (needs.containsKey(c)) {
                // System.out.println("c"+c);
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (needs.get(c) >= windows.get(c)) {
                    match ++;
                }
            }

            while (match == p.length()) {
                if (right - left + 1 == p.length()) res.add(left);
                char c2 = s.charAt(left);
                // System.out.println("c2"+c2);
                if (needs.containsKey(c2)) {
                    windows.put(c2, windows.get(c2) - 1);
                    if (windows.get(c2) < needs.get(c2)) {
                        match --;
                    }
                }
                left ++;
            }
            right ++;
        }
        return res;
    }
}
