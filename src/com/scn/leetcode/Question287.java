package com.scn.leetcode;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-02-04
 */
public class Question287 {
    public int findDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        while (left != right){

            int mid = (left + right)>>1;
            int count = 0;
            for (int num : nums) {
                if(num<=mid){
                    count++;
                }
            }

            if(count>mid){
                right=mid;
            }else {
                left = mid+1;
            }

        }

        return left;

    }
}
