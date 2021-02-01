package com.scn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-01-29
 */
public class Question78 {

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        getRes(nums,0,res);
        return res;
    }

    private static void getRes(int[] nums, int i, List<List<Integer>> res) {
        if(i == nums.length){
            res.add(new ArrayList<>());
            return;
        }else {
            i++;
            getRes(nums, i, res);
            List takeRes = new ArrayList(res.size());
            for (List<Integer> re : res) {
                List<Integer> r = new ArrayList<>(re);
                r.add(nums[i-1]);
                takeRes.add(r);

            }
            res.addAll(takeRes);
        }

    }
}
