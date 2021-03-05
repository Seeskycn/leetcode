package com.scn.datastructure.tree;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-02-28
 */
public class Question654 {

    public static void main(String[] args) {

        TreeNode treeNode = constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
        TreeUtil.printTreePreOrder(treeNode);
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
       return createTree(nums,0,nums.length-1);
    }

    private static TreeNode createTree(int[] nums, int begin, int end) {
        if(begin > end){
            return null;
        }

        int maxIndex = findMaxIndex(nums, begin, end);
        TreeNode node = new TreeNode(nums[maxIndex]);
        node.left = createTree(nums,begin,maxIndex-1);
        node.right = createTree(nums,maxIndex+1,end);
        return node;
    }

    private static int findMaxIndex(int[] nums, int begin, int end) {
        int index = begin;
        for (int i = begin; i <= end; i++) {
            if(nums[i] > nums[index]){
                index = i;
            }
        }
        return index;
    }
}
