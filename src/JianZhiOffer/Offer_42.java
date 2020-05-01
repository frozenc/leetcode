package JianZhiOffer;

public class Offer_42 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0) return 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num:array) {
            if (sum + num < num) {
                sum = num;
            } else {
                sum += num;
            }
            max = Math.max(max, sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        new Offer_42().FindGreatestSumOfSubArray(new int[]{1,-2,3,10,-4,7,2,-5});
    }
}
