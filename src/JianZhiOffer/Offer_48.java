package JianZhiOffer;

//不用加减乘除做加法
public class Offer_48 {
    //或操作表示直接相加，不算进位，与操作并左移只考虑进位，循环，直至加数为0
    public int Add(int num1,int num2) {
        while (num2 != 0) {
            int temp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }
}
