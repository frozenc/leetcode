package leetcode.Tree;

import Util.TreeNode;

import java.util.*;

//二叉树的最近公共祖先
public class Medium_236 {
    //回溯实现
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //根节点为空或者找到了p,q节点
        if (root == null || root == p || root == q) return root;
        //寻找左子树是否包含lca
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //寻找右子树是否包含lca
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //如果左右子树均不为空，表示pq在root两侧，找到了lca
        if (left != null && right != null) return root;
        //如果左右子树有一个为空，即找不到p，q节点，那么另一边就是lca
        return left == null ? right : left;
    }

    //通过迭代+hashmap+set+queue实现
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        parents.put(root, null);
        queue.offer(root);
        while (!parents.containsKey(p) || !parents.containsKey(q)) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                parents.put(node.left, node);
                queue.offer(node.left);
            }
            if (node.right != null) {
                parents.put(node.right, node);
                queue.offer(node.right);
            }
        }

        Set<TreeNode> ancestor = new HashSet<>();
        while (p != null) {
            ancestor.add(p);
            p = parents.get(p);
        }
        while (!ancestor.contains(q)) {
            q = parents.get(q);
        }
        return q;
    }


}
