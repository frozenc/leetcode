package leetcode.SearchProblem;

import java.util.*;

//字母异位词分组
public class Medium_49 {
    //时间复杂度NKlogK,N是strs的长度，KlogK是排序时间，将字符串排序，根据哈希表查找对应的字符串数组
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0) return res;
        Map<String, List<String>> map = new HashMap<>();
        for (String str:strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String s = String.valueOf(c);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<String>());
            }
            map.get(s).add(str);
        }
        for (List<String> list:map.values()) {
            res.add(list);
        }
        return res;
    }

}
