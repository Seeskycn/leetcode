package com.scn.datastructure.tree;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-04-28
 */
public class Question404 {

    public static void main(String[] args) {

    }

    public int sumOfLeftLeaves(TreeNode root) {
       int sum = 0;
       // 左子树不为空
       if(root.left != null){
           // 判断是否为左叶子节点
           if(root.left.left == null && root.left.right == null){
               sum += root.left.val;
           }else {
               sum+=sumOfLeftLeaves(root.left);
           }
       }
       // 右子树不为空
       if(root.right != null){
           sum += sumOfLeftLeaves(root.right);
       }

       return sum;

    }
}
