package leetcode.Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_Medium_39 {
    private List<List<Integer>> lists = new LinkedList<>();


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        dfs(candidates, target, new LinkedList<>(), 0);

        return lists;
    }

    /**
     *
     * @param nums
     * @param target
     * @param res 搜索路径
     * @param begin 去重复，不搜索前面的搜索过的数，已排序
     */
    public void dfs(int[] nums, int target, LinkedList<Integer> res, int begin) {
        if (target == 0) {
            //拷贝搜索路径
            lists.add(new LinkedList<>(res));
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            //剪枝，去除后面更大不符合要求的数
            if (target - nums[i] < 0) break;
            res.add(nums[i]);
            dfs(nums, target-nums[i], res, i);
            res.removeLast();
        }
    }

    public static void main(String[] args) {
        LeetCode_Medium_39 test = new LeetCode_Medium_39();
        test.combinationSum(new int[]{2,3,6,7}, 7);
        System.out.println(test.lists);
    }
}
