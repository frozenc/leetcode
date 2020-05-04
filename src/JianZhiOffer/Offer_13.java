package JianZhiOffer;

//调整数字的顺序
public class Offer_13 {
    //新建奇偶数组
    public void reOrderArray(int [] array) {
        int[] odd = new int[array.length];
        int[] even = new int[array.length];
        int o = 0, e = 0;
        for (int num:array) {
            if (num % 2 != 0) odd[o++] = num;
            else even[e++] = num;
        }
        for (int i=0; i<o; i++) {
            array[i] = odd[i];
        }
        for (int i=0; i<e; i++) {
            array[i+o] = even[i];
        }
    }
    //冒泡排序法思路
    public void reOrderArray2(int [] array) {
        for (int i=0; i<array.length; i++) {
            for (int j = array.length-1; j>i; j--) {
                if (array[j] %2 == 1 && array[j-1] % 2 == 0) {
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }
}
