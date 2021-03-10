package com.scn.leetcode;

import com.scn.sort.SortUtils;

import java.util.BitSet;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-08
 */
public class Question35 {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3},2));
    }

    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;

    }
}
