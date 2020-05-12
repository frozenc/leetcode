package leetcode.String;

import java.util.HashMap;
import java.util.Map;

//最小覆盖子串
public class Hard_76 {
    //滑动窗口法
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";
        Map<Character, Integer> t_map = new HashMap<>();
        for (int i=0; i<t.length(); i++) {
            char c = t.charAt(i);
            t_map.put(c, t_map.getOrDefault(c, 0) + 1);
        }

        int formed = 0;

        int required = t.length();

        Map<Character, Integer> win_map = new HashMap<>();

        int[] ans = {-1, 0, 0};
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            int count = win_map.getOrDefault(c, 0);
            win_map.put(c, count+1);

            if (t_map.containsKey(c) && t_map.get(c).intValue() >= win_map.get(c).intValue()) {
                formed ++;
            }

            while (left <= right && formed == required) {
                c = s.charAt(left);

                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                win_map.put(c, win_map.get(c)-1);
                if (t_map.containsKey(c) && t_map.get(c).intValue() > win_map.get(c).intValue()) {
                    formed --;
                }

                left ++;
            }
            right ++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2]+1);
    }
}
