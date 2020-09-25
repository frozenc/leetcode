package leetcode.Tree;

import Util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode
 * 2020/9/25 21:37
 * 根据后序和中序构造树
 *
 * @author Frozen Chan
 * @since
 **/
public class Medium_106 {
    int post_idx;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> idx_map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        this.post_idx = postorder.length - 1;

        int idx = 0;
        for (int val : inorder) {
            idx_map.put(val, idx ++);
        }
        return helper(0, inorder.length - 1);
    }

    public TreeNode helper(int in_left, int in_right) {
        if (in_left > in_right) {
            return null;
        }


        int rootVal = postorder[post_idx];
        TreeNode root = new TreeNode(rootVal);

        int index = idx_map.get(rootVal);
        post_idx --;
        root.right = helper(index + 1, in_right);
        root.left = helper(in_left, index - 1);

        return root;
    }
}
