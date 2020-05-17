package leetcode.Math;

//直线上的点
public class Hard_149 {
    public int maxPoints(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }
        int i=0;
        //判断有没有不相同的点
        for (;i < points.length-1; i++) {
            if (points[i][0] != points[i+1][0] && points[i][1] != points[i+1][1]) {
                break;
            }
        }
        if (i == points.length-1) {
            return points.length;
        }
        int max = 0;
        for (i=0; i<points.length; i++) {
            for (int j=i+1; j<points.length; j++) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    continue;
                }
                int count = 0;
                for (int k=0; k<points.length; k++) {
                    if (test(points[i][0],points[i][1], points[j][0], points[j][1], points[k][0], points[k][1])) {
                        count ++;
                    }
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }

    public boolean test(int x1, int y1, int x2, int y2, int x, int y) {
        if (x == x1 && y == y1) {
            return true;
        }
        int g1 = gcd(x1-x2, y1-y2);
        int g2 = gcd(x1-x, y1-y);
        return (x1-x2)/g1 == (x1-x)/g2 && (y1-y2)/g1 == (y1-y)/g2;
    }

    public int gcd(int a, int b) {
        int temp;
        while (b != 0) {
            temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
