package leetcode.SearchProblem;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

//根据字符出现频率排序
public class Medium_451 {
    //使用大顶堆排序
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c:s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> heap = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character c1, Character c2) {
                return map.get(c2) - map.get(c1);
            }
        });
        for (char c:map.keySet()) {
            heap.add(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            char c = heap.remove();
            int count = map.get(c);
            while (count-- > 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
