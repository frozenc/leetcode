package leetcode.Tree;

import leetcode.Util.TreeNode;

//删除二叉搜索树中的节点
public class Medium_450 {
    //更优雅的写法，借助递归，前驱后驱节点
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        //待删除节点在右边
        if (root.val < key) root.right = deleteNode(root.right, key);
            //待删除节点在左边
        else if (root.val > key) root.left = deleteNode(root.left, key);
            //找到待删除节点
        else {
            //无孩子节点
            if (root.left == null && root.right == null) return null;
            //右孩子不为空
            if (root.right != null) {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            } else {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    public int successor(TreeNode root) {
        root = root.right;
        while(root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    public int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    //暴力法
    public TreeNode deleteNode2(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key && root.left == null && root.right == null) return null;
        TreeNode parent = root;
        TreeNode delNode = root;
        //寻找待删除节点
        while (delNode.val != key) {
            parent = delNode;
            if (delNode.val < key) {
                delNode = delNode.right;
            } else {
                delNode = delNode.left;
            }
            if (delNode == null) return root;
        }

        //没有孩子节点
        if (delNode.left == null && delNode.right == null) {
            if (delNode == parent.left) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (delNode.left == null) {
            //左孩子为空
            delNode.val = delNode.right.val;
            delNode.left = delNode.right.left;
            delNode.right = delNode.right.right;
        } else {
            //左孩子不为空，用前继节点替换
            TreeNode predecessor = delNode.left;
            TreeNode pParent = predecessor;
            while(predecessor.right != null) {
                pParent = predecessor;
                predecessor = predecessor.right;
            }
            if (pParent == predecessor) {
                delNode.val = predecessor.val;
                delNode.left = predecessor.left;
            } else {
                pParent.right = predecessor.left;
                delNode.val = predecessor.val;
            }
        }

        return root;
    }
}
