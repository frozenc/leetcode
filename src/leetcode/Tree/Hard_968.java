package leetcode.Tree;

import Util.TreeNode;

/**
 * leetcode
 * 2020/9/22 10:01
 * 监控二叉树
 *
 * @author Chan
 * @since
 **/
public class Hard_968 {
    private int camera;

    public int minCameraCover(TreeNode root) {
        //虚拟头
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        dfs(dummy);
        return camera;

    }

    //状态0初始态，表示该节点为叶子节点，直接设为未监控状态
    //状态1表示该节点孩子节点为未监控状态，则该节点必须设添加摄像头，并返回监控状态
    //状态2表示该节点已监控，父节点不需要添加摄像头，直接返回0
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        if (l + r == 0) {
            return 1;
        } else if (l == 1 || r == 1) {
            camera ++;
            return 2;
        } else {
            return 0;
        }
    }
}
