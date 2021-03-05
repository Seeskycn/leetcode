package com.scn.leetcode;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-02-24
 */
public class Question300 {
    public static void main(String[] args) {

    }
    public int lengthOfLIS(int[] nums) {
        return maxLength(nums,0);
    }

    private int maxLength(int[] nums, int cur) {
        int num = 0;
        while (cur+1<nums.length-1 && nums[cur+1]>nums[cur]){

        }


        return 0;
    }
}
