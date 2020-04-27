package leetcode.BackTracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//子集
public class Medium_78 {
    //回溯法
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        for (int j=1; j<=nums.length; j++) {
            helper(nums, res, new ArrayDeque<Integer>(), j, 0);
        }
        return res;
    }

    public void helper(int[] nums, List<List<Integer>> res, Deque<Integer> list, int n, int start) {
        if (list.size() == n) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i=start; i<nums.length; i++) {
            list.push(nums[i]);
            helper(nums, res, list, n, i+1);
            list.pop();
        }
    }

    //迭代
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());

        for (int num:nums) {
            List<List<Integer>> subSets = new ArrayList<>();
            for (List<Integer> cur:res) {
                subSets.add(new ArrayList<Integer>(cur){{add(num);}});
            }
            res.addAll(subSets);
        }
        return res;
    }
}
