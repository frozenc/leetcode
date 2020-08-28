package leetcode.String;

/**
 * leetcode
 * 2020/8/28 16:02
 * 机器人绕圈
 *
 * @author Chan
 * @since
 **/
public class Easy_657 {
    //上下左右
    int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public boolean judgeCircle(String moves) {
        int len = moves.length();
        int x = 0, y = 0;
        for (int i=0; i<len; i++) {
            switch(moves.charAt(i)) {
                case 'U':
                    x += dir[0][0];
                    y += dir[0][1];
                    break;
                case 'D':
                    x += dir[1][0];
                    y += dir[1][1];
                    break;
                case 'L':
                    x += dir[2][0];
                    y += dir[2][1];
                    break;
                case 'R':
                    x += dir[3][0];
                    y += dir[3][1];
                    break;
            }
        }
        return x == 0 && y == 0;
    }

    public boolean judgeCircle2(String moves) {
        int len = moves.length();
        int x = 0, y = 0;
        for (int i=0; i<len; i++) {
            switch(moves.charAt(i)) {
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
            }
        }
        return x == 0 && y == 0;
    }
}
