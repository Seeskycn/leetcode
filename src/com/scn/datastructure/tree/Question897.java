package com.scn.datastructure.tree;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-02-28
 */
public class Question897 {
    static TreeNode cur;
    public static void main(String[] args) {
        TreeNode treeNode = increasingBST(TreeUtil.getTree());
        TreeUtil.printTreePreOrder(treeNode);
    }

    public static TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        cur = ans;
        inorder(root);
        return ans.right;
    }

    private static void inorder(TreeNode node) {
        if (node == null) {return;}
        inorder(node.left);
        node.left = null;
        cur.right = node;
        cur = node;
        inorder(node.right);

    }

}
