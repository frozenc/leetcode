package Util;

import java.util.Scanner;

public class InputUtil {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int num = in.nextInt();
//        for (int k=0; k<num; k++) {
//            int m = in.nextInt();
//            int len = in.nextInt();
//            int[][] grid = new int[m][m];
//            for (int i=0; i<m; i++) {
//                for (int j=0; j<m; j++) {
//                    grid[i][j] = in.nextInt();
//                }
//            }
//            int x = in.nextInt();
//            int y = in.nextInt();
//        }
        String str = in.next();
        String str2 = in.next();
        String str3 = in.nextLine();
        System.out.println("str1:" + str + "-str2:" + str2 + "-str3" + str3);
    }
}
