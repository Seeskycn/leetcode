package com.scn.leetcode;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-04-20
 */
public class Question209 {

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left++];
            }

            right++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;

    }
}
