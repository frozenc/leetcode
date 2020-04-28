package leetcode.Greedy;

import java.util.PriorityQueue;

//最后一块石头的重量
public class Easy_1046 {
    //大顶堆
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(stones.length, (o1, o2)->o2-o1);
        for (int i:stones) {
            heap.add(i);
        }
        while (heap.size() > 1) {
            int num1 = heap.poll();
            int num2 = heap.poll();

            heap.offer(num1-num2);
        }
        return heap.poll();
    }
}
