package leetcode.Array;

import java.util.*;

//找出topk频率的数字
public class Medium_347 {
    //利用最小堆排序，小的放上面，堆的大小超出时，移动堆顶最小元素
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i:nums) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        for (int i:map.keySet()) {
            if (heap.size() < k) {
                heap.add(i);
            } else if (map.get(i) > map.get(heap.peek())){
                heap.poll();
                heap.add(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!heap.isEmpty()) {
            res.add(heap.poll());
        }
        Collections.reverse(res);
        return res;
    }
    //桶排序
    public List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i:nums) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        List<Integer>[] list = new List[nums.length+1];
        for (int key:map.keySet()) {
            int i = map.get(key);
            if (list[i] == null) {
                list[i] = new ArrayList<>();
            }
            list[i].add(key);
        }
        List<Integer> res = new ArrayList<>();
        for (int i=list.length-1; i>=0&&res.size() < k; i--) {
            if (list[i] == null) continue;
            res.addAll(list[i]);
        }
        return res;
    }
}
