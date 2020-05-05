package JianZhiOffer;

import Util.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

//序列化二叉树
public class Offer_61 {
    String Serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.println(cur);
            if (cur == null) {
                sb.append("#,");
            } else {
                sb.append(String.valueOf(cur.val) + ',');
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        return sb.toString();
    }
    TreeNode Deserialize(String str) {
        if (str == "")return null;
        String[] arr = str.split(",");
        int i = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if (arr[i].equals("#")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(arr[i++]));
        queue.offer(root);
        TreeNode cur = null;
        while (i<arr.length-2) {
            cur = queue.poll();
            if (arr[i].equals("#")) {
                cur.left = null;
            } else {
                cur.left = new TreeNode(Integer.valueOf(arr[i]));
                queue.offer(cur.left);
            }
            if (arr[i+1].equals("#")) {
                cur.right = null;
            } else {
                cur.right = new TreeNode(Integer.valueOf(arr[i+1]));
                queue.offer(cur.right);
            }
            i+=2;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        String str = new Offer_61().Serialize(root);
        TreeNode t = new Offer_61().Deserialize(str);
    }
}
