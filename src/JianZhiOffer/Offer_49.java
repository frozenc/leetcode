package JianZhiOffer;

//把字符串转换为整数
public class Offer_49 {
    //仿Integer.parseInt
    public int StrToInt(String str) {
        int len = str.length();
        int res = 0, i=0;
        int digit;
        int multmin;
        int limit = -Integer.MAX_VALUE;
        boolean negative = false;

        if (len > 0) {
            char c = str.charAt(0);
            if (c < '0') {
                if (c == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;
                } else if (c != '+') {
                    return 0;
                }
                if (len == 1) {
                    return 0;
                }
                i++;
            }
            multmin = limit / 10;
            while (i < len) {
                digit = str.charAt(i++) - '0';
                if (digit <0 || digit > 9) return 0;
                //判断如果乘10是否溢出
                if (res < multmin) return 0;
                res *= 10;
                //判断添加新数字是否溢出
                if (res < limit + digit) return 0;
                res -= digit;
            }
        } else {
            return 0;
        }
        return negative ? res : -res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("-2147483649"));
    }
}
