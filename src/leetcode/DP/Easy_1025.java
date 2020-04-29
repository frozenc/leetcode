package leetcode.DP;

//除数博弈
public class Easy_1025 {
    public boolean divisorGame(int N) {
        boolean[] result = new boolean[N+1];
        result[1] = false;
        for (int i=2; i<=N; i++) {
            if (!result[i-1]) {
                result[i] = true;
            }
        }
        return result[N];
    }
    //动态规划
    public boolean divisorGame2(int N) {
        boolean[] result = new boolean[N+1];
        if (N<=1) {
            result[1] = false;
        } else {
            result[2] = true;
            for (int i=3; i<=N; i++) {
                for (int j=1; j<N/2; j++) {
                    if (i%j== 0 && result[i-j] == false) {
                        result[i] = true;
                    }
                }
            }
        }
        return result[N];
    }
}
