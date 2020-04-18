package leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//根据身高排序
public class Medium_406 {
    public int[][] reconstructQueue(int[][] people) {
        //首先按照身高h排序，再按照k排序，h大k小占前面
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });

        List<int[]> list = new ArrayList<>();
        for (int[] p:people) {
            list.add(p[1], p);

        }
        return list.toArray(new int[list.size()][2]);
    }
}
