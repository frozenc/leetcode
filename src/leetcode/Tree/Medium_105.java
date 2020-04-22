package leetcode.Tree;

import leetcode.Util.TreeNode;

import java.util.HashMap;
import java.util.Map;

//根据前序中序构建二叉搜索树
public class Medium_105 {
    int pre_idx = 0;
    int[] preorder;
    int[] inorder;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for(int i=0;i<inorder.length;i++) {
            map.put(inorder[i],i);
        }
        return helper(0, inorder.length-1);
    }

    public TreeNode helper(int left, int right) {
        //没有空余元素
        if (left > right) return null;
        TreeNode root = new TreeNode(preorder[pre_idx++]);
        int index = map.get(root.val);
        root.left = helper(left, index-1);
        root.right = helper(index + 1, right);
        return root;
    }
}
