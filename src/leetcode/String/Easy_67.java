package leetcode.String;

//二进制求和
public class Easy_67 {
    //逐位运算
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int len_a = a.length();
        int len_b = b.length();
        int n = Math.max(len_a, len_b), carry = 0;
        for (int i=0; i<n; i++) {
            carry += i < len_a ? a.charAt(len_a - 1 - i) - '0' : 0;
            carry += i < len_b ? b.charAt(len_b - 1 - i) - '0' : 0;
            sb.append((char)(carry % 2 + '0'));
            carry /= 2;
        }
        if (carry > 0) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}
