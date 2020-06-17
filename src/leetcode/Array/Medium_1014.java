package leetcode.Array;

//最佳观光组合
public class Medium_1014 {
    public int maxScoreSightseeingPair(int[] A) {
        int maxScore = Integer.MIN_VALUE;
        int good = A[0] + 0;
        for (int i=1; i<A.length; i++) {
            maxScore = Math.max(maxScore, good + A[i] - i);
            good = Math.max(good, A[i] + i);
        }
        return maxScore;
    }
}
