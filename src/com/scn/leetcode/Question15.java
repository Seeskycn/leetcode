package com.scn.leetcode;

import java.util.*;

/**
 * @author chaonan shan
 * @description： 三数求和为0
 * @since 2020-07-14
 */
public class Question15 {

    public static void main(String[] args) {
        int[] ints = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(ints));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        getResult(nums,0,0,res,new LinkedList<>());
        return res;
    }

    private static void getResult(int[] nums, int begin,int target,List<List<Integer>> res, LinkedList<Integer> path) {

        if(path.size() == 3){
            int sum = 0;
            for (Integer integer : path) {
                sum += integer;
            }
            if(sum == 0){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            if(path.size() == 0 && nums[i] > 0){
                return;
            }
            if(nums[i]>0 && target < 0){
                return;
            }
            path.addLast(nums[i]);
            getResult(nums,i+1,target-nums[i],res,path);
            path.removeLast();
            while (i+1<nums.length && nums[i] == nums[i+1]){
                i++;
            }

        }
    }
}
