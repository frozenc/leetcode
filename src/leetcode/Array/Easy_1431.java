package leetcode.Array;

import java.util.ArrayList;
import java.util.List;

//拥有糖果最多的孩子
public class Easy_1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        int n = candies.length;
        for (int i=1; i<n; ++i) {
            max = Math.max(candies[i], max);
        }
        List<Boolean> res = new ArrayList<>();
        for (int i=0; i<n; ++i) {
            res.add(candies[i] >= max - extraCandies);
        }
        return res;
    }
}
