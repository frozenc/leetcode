package leetcode.SearchProblem;

import java.util.HashMap;
import java.util.Map;

//四数相加
public class Medium_454 {
    //两两数组看成一个整体，利用hashmap实现
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i=0; i<A.length; i++) {
            for (int j=0; j<B.length; j++) {
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }
        }
        for (int i=0; i<C.length; i++) {
            for (int j=0; j<D.length; j++) {
                int sum = C[i] + D[j];
                res += map.getOrDefault(-sum,0);
            }
        }
        return res;
    }
}
