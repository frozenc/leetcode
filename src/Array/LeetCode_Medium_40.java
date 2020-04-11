package Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_Medium_40 {
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
            //剪枝，删除新路径时重复数
            if (i > begin && nums[i] == nums[i-1]) continue;
            res.add(nums[i]);
            dfs(nums, target-nums[i], res, i+1);
            res.removeLast();
        }
    }

    public static void main(String[] args) {
        LeetCode_Medium_40 test = new LeetCode_Medium_40();
        test.combinationSum(new int[]{10,1,2,7,6,1,5}, 8);
        System.out.println(test.lists);
    }
}
