package JianZhiOffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

//最小K个数
public class Offer_29 {
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

    //快排思路
    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (k > input.length || k == 0) {
            return res;
        }
        int left = 0, right = input.length - 1;
        while (left <= right) {
            int idx = partition(input, left, right);
            if (idx + 1 == k) {
                for (int i = 0; i <= idx; i ++) {
                    res.add(input[i]);
                }
                return res;
            }
            if (idx + 1 > k) {
                right = idx - 1;
            } else {
                left = idx + 1;
            }
        }
        return res;
    }

    public int partition(int[] input, int left, int right) {
        int pivot = input[right];
        int i = left;
        for (int j = left; j < right; j ++) {
            if (input[j] < pivot) {
                swap(input, i, j);
                i ++;
            }
        }
        swap(input, i, right);
        return i;
    }

    public void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void main(String[] args) {
        int[] input = {4,5,1,6,2,7,3,8};
        new Offer_29().GetLeastNumbers_Solution2(input, 4);
    }
}
