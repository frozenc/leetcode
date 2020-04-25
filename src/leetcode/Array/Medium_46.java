package leetcode.Array;

import java.util.*;

//全排列
public class Medium_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> output = new ArrayList<>();
        for (int num:nums) {
            output.add(num);
        }
        helper(nums.length, output, res, 0);
        return res;
    }

    public void helper(int n, ArrayList<Integer> output, List<List<Integer>> res, int first) {
        if (first == n) res.add(new ArrayList<Integer>(output));
        for (int i=first; i<n; i++) {
            //交换首数字
            Collections.swap(output, first, i);
            //计算首数字后面的排列组合
            helper(n, output, res, first+1);
            //重置数组
            Collections.swap(output, first, i);
        }
    }
}
