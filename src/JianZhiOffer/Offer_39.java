package JianZhiOffer;

//查找数组中出现次数超过一半的数字
public class Offer_39 {
    public int MoreThanHalfNum_Solution(int [] array) {
        int n = array.length;
        if (n == 0) return 0;
        int num = array[0];
        int count = 0;
        for (int number:array) {
            if (num == number) count ++;
            else  count --;
            if (count == 0) {
                num = number;
                count ++;
            }
        }
        count = 0;
        for (int number:array) {
            if (number == num) count ++;
        }
        return count > n/2 ? num : 0;
    }
}
