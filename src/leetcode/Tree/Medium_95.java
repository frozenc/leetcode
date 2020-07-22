package leetcode.Tree;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.List;

//不同的二叉搜索树
public class Medium_95 {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) {
            return new ArrayList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        for (int i=start; i<=end; i++) {
            List<TreeNode> leftTree = generateTrees(start, i-1);
            List<TreeNode> rightTree = generateTrees(i+1, end);

            for (TreeNode left:leftTree) {
                for (TreeNode right:rightTree) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = left;
                    cur.right = right;
                    allTrees.add(cur);
                }
            }
        }
        return allTrees;


    }
}
