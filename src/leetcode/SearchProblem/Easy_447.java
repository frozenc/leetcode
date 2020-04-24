package leetcode.SearchProblem;

import java.util.HashMap;
import java.util.Map;

//回旋镖的数量
public class Easy_447 {
    //利用哈希表记录当前距离的点的数量
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0; i<points.length; i++) {
            map.clear();
            for (int j=0; j<points.length; j++) {
                if(j==i) continue;
                int d = distance(points[i], points[j]);
                if (map.containsKey(d)) {
                    //只要顺序不同，可以重复计算
                    count += map.get(d) * 2;
                    map.put(d, map.get(d) + 1);
                } else {
                    map.put(d, 1);
                }
            }
        }
        return count;
    }

    public int distance(int[] p1, int[] p2) {
        int deltaX = p1[0] - p2[0];
        int deltaY = p1[1] - p2[1];
        return (int)Math.pow(deltaX, 2) + (int)Math.pow(deltaY, 2);
    }
}
