package ByteDanceExplore.String;

/**
 * leetcode
 * 2021/1/4 13:01
 * 字符串相乘
 *
 * @author Frozen Chan
 * @since
 **/
public class Multiply {
    //每一位与整个数字相乘，做加法
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String res = "0";
        int m = num1.length(), n = num2.length();

        for (int i = n - 1; i >= 0; --i) {
            StringBuilder cur = new StringBuilder();
            int add = 0;
            for (int j = n - 1; j > i; -- j) {
                cur.append("0");
            }
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; -- j) {
                int x = num1.charAt(j) - '0';
                int product = x * y + add;
                cur.append(product % 10);
                add = product / 10;
            }
            if (add != 0) {
                cur.append(add % 10);
            }
            res = addString(res, cur.reverse().toString());
        }
        return res;
    }

    public String addString(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int x = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int add = x + y + carry;
            res.append(add % 10);
            carry = add / 10;
        }
        if (carry != 0) {
            res.append(carry);
        }
        return res.reverse().toString();
    }

    // 一位一位做乘法，再累加
    public String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length(), add = 0;

        int[] resArray = new int[m + n + 1];
        for (int i = m - 1; i >= 0; --i) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; --j) {
                int y = num2.charAt(j) - '0';
                resArray[i + j + 1] += x * y;
            }
        }
        for (int i = m + n - 1; i > 0; --i) {
            resArray[i - 1] += resArray[i] / 10;
            resArray[i] = resArray[i] % 10;
        }
        int index = resArray[0] == 0 ? 1 : 0;
        StringBuilder res = new StringBuilder();
        while(index < m + n) {
            res.append(resArray[index ++]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Multiply().multiply("123456789", "987654321"));
    }
}
