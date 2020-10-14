package leetcode.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode
 * 2020/10/14 11:29
 * 查找常用字符
 *
 * @author Frozen Chan
 * @since
 **/
public class Easy_1002 {
    public List<String> commonChars(String[] A) {
        Map<Character, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        if (A.length == 0) {
            return res;
        }
        for (char c : A[0].toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 1; i < A.length; i ++) {
            Map<Character, Integer> map2 = new HashMap<>();
            for (char c : A[i].toCharArray()) {
                if (map.containsKey(c)) {
                    map2.put(c, Math.min(map2.getOrDefault(c, 0) + 1, map.get(c)));
                }
            }
            map = map2;
        }
        for (char c : map.keySet()) {
            int num = map.get(c);
            for (int i = 0; i < num; i++) {
                res.add(String.valueOf(c));
            }
        }
        return res;
    }
}
