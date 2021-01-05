package com.scn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chaonan shan
 * @description： 三数求和为0
 * @since 2020-07-14
 */
public class Question15 {

    public static void main(String[] args) {
        int[] ints = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(ints));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        getResult(nums,0,3,0,path,res);

         return res;
    }

    private static void getResult(int[] nums, int begin, int count, int sum, List<Integer> path, List<List<Integer>> res) {
        if(begin > nums.length -1){
            return ;
        }
        if( nums.length - begin < count){
            return;
        }
        if(count == 1 ){
            for (int i = begin; i < nums.length; i++) {
                if(nums[begin] == sum){
                    ArrayList<Integer> integers = new ArrayList<>(path);
                    integers.add(sum);
                    res.add(integers);
                    break;
                }
            }
            return ;
        }
        int sum1 = sum -nums[begin];
        for (int i = begin; i < nums.length; i++) {
            path.add(nums[i]);
            int next = i + 1;
            getResult(nums,next, count - 1, sum1, path, res);
            path.remove((Object)new Integer(nums[i]));
        }
    }
}
