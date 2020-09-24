package leetcode.Tree;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode
 * 2020/9/24 14:21
 * 树的众数
 *
 * @author Frozen Chan
 * @since
 **/
public class Easy_501 {
    private int base = 0, count = 0, most = 0;
    private List<Integer> res = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        TreeNode cur = root, pre = null;
        //Morris中序遍历，寻找前驱结点连接到当前节点
        while (cur != null) {
            if (cur.left == null) {
                update(cur.val);
                cur = cur.right;
                continue;
            }
            pre = cur.left;
            while (pre.right != null && pre.right != cur) {
                pre = pre.right;
            }
            if (pre.right == null) {
                pre.right = cur;
                cur = cur.left;
            } else {
                pre.right = null;
                update(cur.val);
                cur = cur.right;
            }

        }

        int size = res.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }


    public void update(int x) {
        if (x == base) {
            count ++;
        } else {
            count = 1;
            base = x;
        }
        if (count == most) {
            res.add(base);
        }
        if (count > most) {
            res.clear();
            most = count;
            res.add(base);
        }
    }
    //O(n)空间实现
    public int[] findMode2(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> array = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        dfs(root, array);
        int count = 1, most = 1;
        int base = array.get(0), len = array.size();
        res.add(array.get(0));

        for (int i = 1; i < len; i ++) {
            int x = array.get(i);
            if (x == base) {
                count ++;
            } else {
                count = 1;
                base = x;
            }
            if (count == most) {
                res.add(x);
            }
            if (count > most) {
                most = count;
                res.clear();
                res.add(base);
            }
        }

        int size = res.size();

        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }


    public void dfs(TreeNode root, List<Integer> array) {
        if (root == null) {
            return;
        }
        dfs(root.left, array);
        array.add(root.val);
        dfs(root.right, array);
    }
}
