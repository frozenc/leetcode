package JianZhiOffer;

import Util.TreeNode;

import java.util.HashMap;
import java.util.Map;

//重建二叉树，根据前序跟后序实现
public class Offer_4 {
    int pre_idx = 0;
    Map<Integer, Integer> map = new HashMap<>();
    int[] pre;
    int[] in;
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        this.pre = pre;
        this.in = in;
        for (int i=0; i<in.length; i++) {
            map.put(in[i], i);
        }
        return helper(0, in.length-1);
    }

    public TreeNode helper(int left, int right) {
        if (left > right) return null;
        TreeNode root = new TreeNode(pre[pre_idx++]);
        int mid = map.get(root.val);
        root.left = helper(left, mid-1);
        root.right = helper(mid+1, right);
        return root;
    }
}
