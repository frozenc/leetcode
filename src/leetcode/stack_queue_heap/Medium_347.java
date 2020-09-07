package leetcode.stack_queue_heap;

import java.util.*;

/**
 * leetcode
 * 2020/9/7 16:46
 * 找出前k个高频数字
 *
 * @author Chan
 * @since
 **/
public class Medium_347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int count = entry.getValue();
            if (heap.size() == k) {
                if (count > heap.peek()[1]) {
                    heap.poll();
                    heap.offer(new int[]{key, count});
                }
            } else {
                heap.offer(new int[]{key, count});
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(heap.poll()[0]);
        }
        return res;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }

        List<int[]> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new int[]{entry.getKey(), entry.getValue()});
        }

        int[] res = new int[k];
        quickSort(list, res, 0, list.size() - 1, 0, k);
        return res;
    }

    public void quickSort(List<int[]> list, int[] res, int start, int end, int retIndex, int k) {
        int index = start;
        int[] pivot = list.get(end);
        for (int i = start; i < end; i++) {
            if (list.get(i)[1] > pivot[1]) {
                Collections.swap(list, index, i);
                index++;
            }
        }
        Collections.swap(list, index, end);

        if (k <= index - start) {
            quickSort(list, res, start, index - 1, retIndex, k);
        } else {
            for (int i = start; i <= index; i++) {
                res[retIndex++] = list.get(i)[0];
            }
            if (k > index - start + 1) {
                quickSort(list, res, index + 1, end, retIndex, k - (index - start + 1));
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 4, 1, 2};
        new Medium_347().topKFrequent(nums, 3);
    }
}
