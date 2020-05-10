package JianZhiOffer;

//表示数值的字符串
public class Offer_53 {
    public boolean isNumeric(char[] str) {
        boolean sign = false, decimal = false, hasE = false;
        int len = str.length;
        for (int i=0; i<len; i++) {
            if (str[i] == 'e' || str[i] == 'E') {
                //e后面必须接着数字且只能有一个E
                if (i == len-1 || hasE) return false;
                hasE = true;
            } else  if (str[i] == '+' || str[i] == '-') {
                //第二次出现+号必须跟在e后面
                if (sign && str[i-1] != 'e' && str[i-1] != 'E') return false;
                //第一次出现+号不在字符开头也必须跟在e后面
                if (!sign && i>0 && str[i-1] != 'e' && str[i-1] != 'E') return false;
                sign = true;
            } else if (str[i] == '.') {
                if (hasE || decimal) return false;
                decimal = true;
            } else if (str[i] < '0' || str[i] > '9') {
                return false;
            }
        }
        return true;
    }
}
