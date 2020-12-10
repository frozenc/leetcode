package JianZhiOffer;

//正则表达式匹配
public class Offer_52 {
    public boolean match(char[] str, char[] pattern)
    {
        if (str == null && pattern == null) return true;
        if (pattern == null) return false;
        int strIndex = 0;
        int patternIndex = 0;
        return matchHelper(str, pattern, strIndex, patternIndex);
    }

    public boolean matchHelper(char[] str, char[] pattern, int strIndex, int patIndex) {
        //两个字符串同时到达结尾
        if (strIndex == str.length && patIndex == pattern.length) {
            return true;
        }
        if (strIndex != str.length && patIndex == pattern.length) {
            return false;
        }

        //模式第二个时*,且字符串第一个跟模式第一个匹配
        if (patIndex + 1 < pattern.length && pattern[patIndex+1] == '*') {
            if (strIndex != str.length && (str[strIndex] == pattern[patIndex] ||
                    (str[strIndex] != pattern[patIndex] && pattern[patIndex] == '.'))) {
                return matchHelper(str, pattern, strIndex, patIndex + 2) || //模式匹配0个字符
                        matchHelper(str, pattern, strIndex + 1, patIndex + 2) ||//模式匹配一个字符
                        matchHelper(str, pattern, strIndex + 1, patIndex); //继续匹配下一个字符
            } else {
                return matchHelper(str, pattern, strIndex, patIndex + 2); // 模式不匹配或str已到末尾
            }
        }
        //模式第二个不为*
        if(strIndex != str.length && (str[strIndex] == pattern[patIndex] || pattern[patIndex] == '.')) {
            return matchHelper(str, pattern, strIndex + 1, patIndex+1);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Offer_52().match("bbbba".toCharArray(), ".*a*a".toCharArray()));
    }
}
