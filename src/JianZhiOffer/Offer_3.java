package JianZhiOffer;

import java.util.HashSet;
import java.util.Set;

//查找重复数1.排序2.哈希set3.二分查找
public class Offer_3 {
    //hashset实现
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (length == 0) return false;
        Set<Integer> set = new HashSet<>();
        for (int num:numbers) {
            if (set.contains(num)) {
                duplication[0] = num;
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
