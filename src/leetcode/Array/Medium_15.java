package leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//三数之和
public class Medium_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int k=0;k<nums.length-2;k++) {
            //大于0，后面数字相加不可能大于0，退出
            if (nums[k] > 0) break;
            //数字相同，重复，下一步
            if (k>0 && nums[k] == nums[k-1]) continue;
            int i = k+1, j = nums.length-1;
            //变成两数之和问题，寻找所有可能的组合
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    //跳过重复数字
                    while (i<j && nums[i] == nums[++i]);
                    while (i<j && nums[j] == nums[--j]);
                } else if (sum > 0) {
                    while (i<j && nums[j] == nums[--j]);
                } else if (sum < 0) {
                    while (i<j && nums[i] == nums[++i]);
                }
            }

        }

        return list;
    }
}
