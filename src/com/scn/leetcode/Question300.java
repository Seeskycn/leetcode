package com.scn.leetcode;

import java.util.Stack;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-02-24
 */
public class Question300 {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{4,10,4,3,8,9}));

    }
    public static int lengthOfLIS(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] res = new int[nums.length];
        int maxRes = 0;
        for (int i = 0; i < nums.length; i++) {
            res[i] = 1;
            if(i != 0){
                for (int j = 0; j < i; j++) {
                    if(nums[j]<nums[i]){
                        res[i] = Math.max(res[i],res[j]+1);
                    }
                }
            }
            maxRes = Math.max(res[i],maxRes);
        }
        return maxRes;


    }


}
