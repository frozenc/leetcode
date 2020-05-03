package JianZhiOffer;

import java.util.HashSet;
import java.util.Set;

//数组中只出现一次的两个数字
public class Offer_56 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Set<Integer> set = new HashSet<>();
        for (int num:array) {
            if (set.contains(num)){
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        int count=0;
        for (int num:set) {
            if (count == 0) {
                num1[0] = num;
            } else {
                num2[0] = num;
            }
            count ++;
        }
    }

    //通过位运算实现
    public void FindNumsAppearOnce2(int [] array,int num1[] , int num2[]) {
        if (array.length < 2) return;
        int bitNum = 1;
        int result = 0;
        for (int i=0; i<array.length; i++) {
            result ^= array[i];
        }
        //从右开始查找第一个不为0的位数
        while ((result & bitNum) == 0) bitNum <<= 1;
        //按照第一个为1的位数，进行异或操作，分成两组，两个不重复的数字肯定分在不同的两组
        for (int i=0; i<array.length; i++) {
            if ((bitNum & array[i]) == 0) {
                num2[0] ^= array[i];
            }
            else {
                num1[0] ^= array[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,4,1,3,3,5,5};
        new Offer_56().FindNumsAppearOnce(array, new int[1], new int[1]);
    }
}
