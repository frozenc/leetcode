package JianZhiOffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

//最小K个数
public class Offer_40 {
    //大顶堆实现
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (k > input.length || k==0) return res;
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int num:input) {
            if (heap.size() == k) {
                if (heap.peek() > num) {
                    heap.poll();
                    heap.offer(num);
                }
            } else {
                heap.offer(num);
            }

        }

        for (int num:heap) {
            res.add(num);
        }
        return res;
    }
}
