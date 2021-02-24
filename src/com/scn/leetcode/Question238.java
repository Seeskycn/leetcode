package com.scn.leetcode;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-02-04
 */
public class Question238 {

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = k;
            k = k*nums[i];
        }
        k = 1;
        for (int i = nums.length - 1; i >=0 ; i--) {
                res[i]*=k;
                k*=nums[i];
        }
        return res;
    }
}
