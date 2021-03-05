package com.scn.datastructure.tree;

/**
 * @author chaonan shan
 * @description： TODO 未完成
 * @since 2021-03-02
 */
public class Question437 {

    int count;
    int totalSum;
    public int pathSum(TreeNode root, int sum) {
        this.totalSum = sum;
        if (root == null) {
            return count;
        }

        // 当前节点不拿
       count = (pathSum(root.left,totalSum)+ pathSum(root.right,totalSum)) + (pathSum(root.left,sum-root.val)+pathSum(root.right,sum-root.val)) ;




        return count;

    }
}
