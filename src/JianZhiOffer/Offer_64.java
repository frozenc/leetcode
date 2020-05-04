package JianZhiOffer;

import java.util.ArrayDeque;
import java.util.ArrayList;

//滑动窗口的最大值
public class Offer_64 {
    //暴力法
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if (size == 0) return res;
        for (int i=0; i<num.length-size+1; i++) {
            int max = num[i];
            for (int j=1; j<size; j++) {
                if (num[i+j] > max) max = num[i+j];
            }
            res.add(max);
        }
        return res;
    }
    //  滑动窗口的最大值
    public ArrayList<Integer> maxInWindows2(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if (num.length < size || size <= 0) return res;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i=0; i<num.length; i++) {
            int begin = i-size+1;
            if (queue.isEmpty()) {
                queue.offer(i);
            } else if (begin > queue.getFirst()) {
                //判断数组中的最大值的下标是否过期
                queue.pollFirst();
            }
            //把前面不如自己大的全部移除，有可能令数组为空
            while (!queue.isEmpty() && num[queue.peekLast()] <= num[i]) {
                queue.pollLast();
            }
            queue.offer(i);
            if (begin >= 0) {
                res.add(num[queue.peekFirst()]);
            }
        }
        return res;
    }
}
