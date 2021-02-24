package com.scn.leetcode;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-02-22
 */
public class Question53 {
    public static void main(String[] args) {
        int[] ints = new int[]{0,1,3,-1,2};
        System.out.println(maxSubArray(ints));
    }

    public static int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int currentSum = nums[0];
        int maxSum = currentSum;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]<0){
                maxSum = Math.max(maxSum, currentSum);
            }
            if(currentSum < 0 ){
                currentSum = nums[i];
            }else {
                currentSum += nums[i];
            }
        }
        return Math.max(maxSum,currentSum);
    }
}
