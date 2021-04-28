package com.scn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-04-28
 */
public class Question442 {

    public static void main(String[] args) {
        System.out.println(findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1,7}));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            nums[(nums[i] - 1) % n] += n;
        }
        for (int i = 0; i < nums.length; i++) {
           if(nums[i] > (2 * n)) {
               res.add(i+1);
           }
        }
        return res;

    }
}
