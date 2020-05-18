package leetcode.DP;

//地下城游戏
public class Hard_174 {
    //从右下往坐上走，记录到达当前所格子需生命值
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];

        for (int i=m-1; i>=0; i--) {
            for (int j=n-1; j>=0; j--) {
                if (i+1 < m && j+1 < n) {
                    int needMin = Math.min(dp[i][j+1], dp[i+1][j]) - dungeon[i][j];
                    dp[i][j] = Math.max(0, needMin);
                } else if (i+1 < m) {
                    //在这一格需要的血量，下一格的所需血量减去本格获得的血量
                    //若needmin为负，不需要血量，若needmin为正，需要血量
                    int needMin = dp[i+1][j] - dungeon[i][j];
                    dp[i][j] = Math.max(0, needMin);
                } else if (j+1 < n) {
                    int needMin = dp[i][j+1] - dungeon[i][j];
                    dp[i][j] = Math.max(0, needMin);
                } else {
                    dp[i][j] = Math.max(0, -dungeon[i][j]);
                }
                System.out.println(dp[i][j]);
            }
        }
        return dp[0][0]+1;
    }
}
