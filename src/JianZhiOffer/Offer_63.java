package JianZhiOffer;

import java.util.PriorityQueue;

//从数据流中获取中位数
public class Offer_63 {
    //使用大小顶堆实现
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o2-o1));
    int count = 0;

    public void Insert(Integer num) {
        count ++;
        if (count % 2 == 1) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        } else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
    }

    public Double GetMedian() {
        if (count % 2 == 1) {
            return (double) minHeap.peek();
        } else {
            return (double)(minHeap.peek() + maxHeap.peek())/2;
        }
    }
}
