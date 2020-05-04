package JianZhiOffer;

import java.util.ArrayList;

//和为S的两个数字
public class Offer_42 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        int min = Integer.MAX_VALUE;
        int left = 0, right = array.length-1;
        ArrayList<Integer> list = new ArrayList<>();
        while (left < right) {
            int mySum = array[left] + array[right];
            //乘积最小的一定是第一组，可直接返回
            if (mySum == sum) {
                if (min > array[left] * array[right]) {
                    min = array[left] * array[right];
                    list.clear();
                    list.add(array[left]);
                    list.add(array[right]);
                }
                left ++;
                right --;
            } else if (mySum < sum) {
                left ++;
            } else {
                right --;
            }
        }
        return list;
    }
}
