package com.scn.datastructure.tree;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-01
 */
public class Offer54 {

    static int res, k;

    public static void main(String[] args) {
        System.out.println(kthLargest(TreeUtil.getTree(), 2));
    }

    public static int kthLargest(TreeNode root, int k) {
        Offer54.k = k;
        inorderT(root);
        return res;
    }

    private static void inorderT(TreeNode root) {
        if (root == null) {
            return ;
        }
        inorderT(root.right);
        if (k == 0) {
            return ;
        }
        if(--k == 0){
            res =  root.val;
        }
        inorderT(root.left);

    }

}
