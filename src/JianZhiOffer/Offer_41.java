package JianZhiOffer;

import java.util.ArrayList;

//和为s的连续正数序列
public class Offer_41 {
    //暴力法
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        int right = (sum + 1) / 2;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer> >();
        for (int i = 1; i <= right; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            int count = i;
            list.add(i);
            for (int j = i+1; j<= right; j++) {
                count += j;
                list.add(j);
                if (count == sum) {
                    res.add(list);
                    break;
                } else if (count > sum) {
                    break;
                }
            }
        }
        return res;
    }

    //双指针滑动窗口
    public ArrayList<ArrayList<Integer> > FindContinuousSequence2(int sum) {
        int left = 1, right = 2;
        ArrayList<ArrayList<Integer> > res = new ArrayList<ArrayList<Integer> >();
        while (left < right) {
            int count = (left + right) * (right - left + 1) / 2;
            if (count == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i=left; i<= right; i++) {
                    list.add(i);
                }
                res.add(list);
                left ++;
            } else if (count < sum) {
                right ++;
            } else {
                left ++;
            }
        }
        return res;
    }
}
