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

    //剑指offer书上解法
    int index;

    public boolean isNumber(String s) {
        index = 0;

        while (index < s.length() && s.charAt(index) == ' ') {
            ++ index;
        }

        boolean numeric = scanInteger(s);

        //查看小数部分
        if (index < s.length() && s.charAt(index) == '.') {
            ++ index;
            //小数部分没有+-号
            //小数部分前面可以没有整数.233
            //小数部分后面可以没有整数233.
            numeric = scanUnsignedInteger(s) || numeric;
        }

        //查看指数部分
        if (index < s.length() && (s.charAt(index) == 'e' || s.charAt(index) == 'E')) {
            ++ index;
            numeric = numeric && scanInteger(s);
        }

        while (index < s.length() && s.charAt(index) == ' ') {
            ++ index;
        }

        return numeric && index == s.length();
    }

    public boolean scanInteger(String s) {
        if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            ++ index;
        }
        return scanUnsignedInteger(s);
    }

    public boolean scanUnsignedInteger(String s) {
        int before = index;
        while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
            ++ index;
        }
        return index > before;
    }
}
