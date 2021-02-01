package com.scn.leetcode;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-01-26
 */
public class Question55 {

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{1, 2, 3}));
    }

    public static boolean canJump(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if(k >= nums.length){
                break;
            }
            if (i > k) {
                return false;
            }
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }

}
