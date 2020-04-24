package leetcode.SearchProblem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//单词规律
public class Easy_290 {
    //哈希表映射实现
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        String[] arr = str.split(" ");
        if (pattern.length() != arr.length) return false;
        for (int i=0; i<pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(arr[i])) {
                    return false;
                }
            } else {
                if (set.contains(arr[i])) return false;
                set.add(arr[i]);
                map.put(c, arr[i]);
            }
        }
        return true;
    }
    //构建数组下标映射表
    public boolean wordPattern2(String pattern, String str) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        String[] arr = str.split(" ");
        if (pattern.length() != arr.length) return false;
        for (int i=0; i<pattern.length(); i++) {
            char c = pattern.charAt(i);
            int idx1 = map1.getOrDefault(c, -1);
            int idx2 = map2.getOrDefault(arr[i], -1);
            if (idx1 == idx2) {
                map1.put(c, i);
                map2.put(arr[i], i);
            } else {
                return false;
            }
        }
        return true;
    }
    //方法二简洁写法
    //map的put方法，如果key不存在，返回null，如果key存在，返回之前对应的value
    //循环用Integer，map中的value是Integer，如果用int，java自动装箱，判断两个对象判断的是引用的地址
    //数字范围在[-128,127]时，共享地址
    public boolean wordPattern3(String pattern, String str) {
        Map index = new HashMap<>();
        String[] arr = str.split(" ");
        if (pattern.length() != arr.length) return false;
        for (Integer i=0; i<pattern.length(); i++) {
            if (index.put(pattern.charAt(i), i) != index.put(arr[i], i)) return false;
        }
        return true;
    }
}
