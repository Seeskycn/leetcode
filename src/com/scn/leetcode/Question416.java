package com.scn.leetcode;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-25
 */
public class Question416 {

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 5, 11, 5}));
    }
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        int[] dp = new int[20000];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j],dp[j-nums[i]] + nums[i]);
            }
        }

        return dp[target] == target;
    }
}
