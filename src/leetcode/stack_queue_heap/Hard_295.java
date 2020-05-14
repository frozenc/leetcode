package leetcode.stack_queue_heap;

import java.util.PriorityQueue;

//数据流的中位数MedianFinder
public class Hard_295 {
    PriorityQueue<Integer> q1;
    PriorityQueue<Integer> q2;
    int count;

    /** initialize your data structure here. */
    public Hard_295() {
        q1 = new PriorityQueue<>();
        q2 = new PriorityQueue<>((o1,o2)->o2-o1);
        count = 0;
    }

    public void addNum(int num) {
        if (q1.isEmpty()) {
            q1.add(num);
        } else if (count % 2 == 1) {//现在共有奇数个，应放入q2
            if (num >= q1.peek()) {
                q2.add(q1.poll());
                q1.add(num);
            } else {
                q2.add(num);
            }
        } else if (count % 2 == 0){//现在共有偶数个，应放入q1
            if (num >= q1.peek()) {
                q1.add(num);
            } else {
                q2.add(num);
                q1.add(q2.poll());
            }
        }
        count ++;
    }

    public double findMedian() {
        if (count % 2 == 0) {
            return (double)((q1.peek() + q2.peek()) / 2.0);
        } else {
            return (double)q1.peek();
        }
    }
}
