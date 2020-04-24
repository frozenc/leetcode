package leetcode.SearchProblem;

import java.util.HashMap;
import java.util.Map;

//共享字符串
public class Easy_205 {
    //双哈希表记录字符对应数组下标
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            int idx1 = map1.getOrDefault(c1, -1);
            int idx2 = map2.getOrDefault(c2, -1);
            if (idx1 == idx2) {
                map1.put(c1, i);
                map2.put(c2, i);
            } else {
                return false;
            }
        }
        return true;
    }
//    单哈希表映射
    public boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char key = s.charAt(i);
            char value = t.charAt(i);
            if (map.containsKey(key)) {
                if (map.get(key) != value) {
                    return false;
                }
            } else {
                if (map.containsValue(value)) {
                    return false;
                } else {
                    map.put(key, value);
                }
            }
        }
        return true;
    }
}
