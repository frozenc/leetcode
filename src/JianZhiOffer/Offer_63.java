package JianZhiOffer;

import java.util.ArrayList;
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

    //使用插入排序实现
    ArrayList<Integer> nums = new ArrayList<>();

    public void Insert2(Integer num) {
        if (nums.size() == 0) {
            nums.add(num);
        } else {
            int n = nums.size();
            for (int i = 0; i < n; i ++) {
                int current = i;
                if (nums.get(i) > num) {
                    nums.add(-1);
                    while (n > current) {
                        nums.set(n, nums.get(n-1));
                        n -- ;
                    }
                    nums.set(current, num);
                    return;
                }
            }
            nums.add(num);
        }
    }

    public Double GetMedian2() {
        int n = nums.size();
        if (n % 2 == 0) {
            return (double)(nums.get(n / 2) + nums.get(n / 2 - 1)) / 2;
        } else {
            return (double)(nums.get(n / 2));
        }
    }
}
