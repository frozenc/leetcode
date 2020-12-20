package JianZhiOffer;

import Util.TreeNode;

import java.util.HashMap;
import java.util.Map;

//重建二叉树，根据前序跟后序实现
public class Offer_4 {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        map = new HashMap<>();
        for (int i = 0; i < pre.length; i ++) {
            map.put(in[i], i);
        }
        return helper(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    public TreeNode helper(int[] pre, int[] in, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preLeft]);
        int mid = map.get(root.val);
        int size = mid - inLeft;
        root.left = helper(pre, in, preLeft + 1, preLeft + size, inLeft, mid - 1);
        root.right = helper(pre, in, preLeft + size + 1, preRight, mid + 1, inRight);
        return root;
    }


    int pre_idx = 0;
    int[] pre;
    int[] in;
    public TreeNode reConstructBinaryTree2(int [] pre, int [] in) {
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
