package leetcode.Tree;

//不同的二叉搜索树
public class Medium_96 {
    //动态规划,给定n个节点，等于每个节点作为根节点时能形成的树的数量之和，小于该节点为左子树，大于该节点为右子树
    public int numTrees(int n) {
        int[] res = new int[n+1];
        res[0] = 1;
        res[1] = 1;

        for (int i=2; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                res[i] += res[j-1] * res[i-j];
            }
        }
        return res[n];
    }
}
