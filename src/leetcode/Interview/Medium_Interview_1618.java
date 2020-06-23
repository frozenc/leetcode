package leetcode.Interview;

//模式匹配
public class Medium_Interview_1618 {
    public boolean patternMatching(String pattern, String value) {
        int count_a = 0, count_b = 0;
        for (char ch:pattern.toCharArray()) {
            if (ch == 'a') {
                ++count_a;
            }else {
                ++count_b;
            }
        }
        //如果a的数目小于b，直接调换，下面枚举的时候默认a的次数不少于b
        if (count_a < count_b) {
            int temp = count_a;
            count_a = count_b;
            count_b = temp;
            char[] p_arr = pattern.toCharArray();
            for(int i=0; i<p_arr.length; i++) {
                p_arr[i] = p_arr[i] == 'a' ? 'b' : 'a';
            }
            pattern = p_arr.toString();
        }

        //如果字符串为0，如果模式也为0，返回true，否则false
        if (value.length() == 0) {
            return count_b == 0;
        }
        //如果模式为0，自字符串不为0，返回false
        if (pattern.length() == 0) {
            return false;
        }

        //a匹配的单词长度枚举
        for (int len_a = 0; len_a * count_a <= value.length(); len_a++) {
            //剩下的是b匹配的单词长度的总和
            int rest = value.length() - len_a * count_a;
            //判断b的数量是否为0，或者rest整除b的数量不为0
            if ((count_b == 0 && rest == 0) || (count_b != 0 && rest % count_b == 0)) {
                int len_b = count_b == 0 ? 0 : rest / count_b;
                int pos = 0;
                boolean correct = true;
                String value_a = "", value_b = "";
                for (char c:pattern.toCharArray()) {
                    if (c == 'a') {
                        String sub = value.substring(pos, pos+len_a);
                        if (value_a.length() == 0) {
                            value_a = sub;
                        } else if (!value_a.equals(sub)) {
                            correct = false;
                            break;
                        }
                        pos += len_a;
                    } else {
                        String sub = value.substring(pos, pos+len_b);
                        if (value_b.length() == 0) {
                            value_b = sub;
                        } else if (!value_b.equals(sub)) {
                            correct = false;
                            break;
                        }
                        pos += len_b;
                    }
                }
                //a跟b字符串不能相等
                if (correct && !value_a.equals(value_b)) {
                    return true;
                }

            }
        }
        return false;
    }
}
