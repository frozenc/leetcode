package leetcode.SearchProblem;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

//存在重复元素3
public class Medium_220 {
    //暴力法滑动窗口，long处理整型溢出
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        long a;
        long b;
        for (int i = 0; i < nums.length-1; ++i) {
            for (int j = i+1; j < nums.length && j-i<=k ; ++j) {
                a = nums[i];
                b = nums[j];
                if (Math.abs(a-b) <= t) return true;
            }
        }
        return false;
    }
    //二叉树查找
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        TreeSet<Integer> tree = new TreeSet<>();
        for (int i=0; i<nums.length; i++) {
            Integer s = tree.ceiling(nums[i]);
            if (s != null && s <= nums[i] + t) return true;
            Integer p = tree.floor(nums[i]);
            if (p != null && nums[i] <= p + t) return true;
            tree.add(nums[i]);
            if (tree.size() > k) {
                tree.remove(nums[i-k]);
            }
        }
        return false;
    }

    //桶排序查找
    public boolean containsNearbyAlmostDuplicate3(int[] nums, int k, int t) {
        if (t<0) return false;
        long w = (long) t + 1;
        Map<Long, Long> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            long id = getBucketId(nums[i], w);
            if (map.containsKey(id)) {
                return true;
            }
            if (map.containsKey(id - 1) && Math.abs(map.get(id-1) - nums[i]) < w) {
                return true;
            }
            if (map.containsKey(id + 1) && Math.abs(map.get(id+1) - nums[i]) < w) {
                return true;
            }
            map.put(id, (long)nums[i]);
            if (i >= k) map.remove(getBucketId((long)nums[i-k], w));
        }
        return false;
    }

    //-3/5=0,令-3/5=-1
    private long getBucketId(long x, long w) {
        return x < 0 ? x/w-1 : x/w;
    }

    public static void main(String[] args) {
        System.out.println(3/-2);
    }
}
