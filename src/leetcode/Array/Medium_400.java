package leetcode.Array;

//寻找第N个数字
public class Medium_400 {
    public int findNthDigit(int n) {
        //1-9有1*1*9个数字，10-99有2*10*9个数字，100-999有3*100*9个数字
        //边界判断可以取102
        int i=1;
        while (n > i*Math.pow(10,i-1)*9) {
            n -= i*Math.pow(10,i-1)*9;
            i ++;
        }
        int number = (n-1)/i + (int)Math.pow(10,i-1);
        String numStr = new Integer(number).toString();
        if (n % i == 0) return numStr.charAt(i-1) - '0';
        return numStr.charAt(n%i-1) - '0';
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(10, 2));
    }
}
