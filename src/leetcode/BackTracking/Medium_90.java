package leetcode.BackTracking;

import java.util.*;

//子集
public class Medium_90 {
    //回溯
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, res, 0, new ArrayDeque<Integer>());
        return res;
    }

    public void helper(int[] nums, List<List<Integer>> res, int start, Deque<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int i=start; i<nums.length; i++) {
            //不计算当前重复值，第一次回溯时直接添加进数组
            if (i>start && nums[i]==nums[i-1]) continue;
            list.push(nums[i]);
            helper(nums, res, i+1, list);
            list.pop();
        }
    }

    //迭代
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        int start = 1;
        for (int i=0; i<nums.length; i++) {
            int n=res.size();
            for (int j=0; j<n; j++) {
                if (i>0 && nums[i]==nums[i-1] && j<start) continue;
                List<Integer> list = res.get(j);
                List<Integer> temp = new ArrayList<>(list);
                temp.add(nums[i]);
                res.add(temp);
            }
            start = n;
        }
        return res;
    }

}
