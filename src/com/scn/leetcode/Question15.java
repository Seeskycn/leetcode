package com.scn.leetcode;

import java.util.*;

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
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        return nSum(nums,0,0,0,3,new ArrayList(),res,set);
    }

    private static List<List<Integer>> nSum(int[] nums,  int count, int sum, int begin, int totalCount,List path, List res, Set<String> set) {
        if(begin >= nums.length){
            return res;
        }
        if(nums.length-begin < totalCount-count){
            return res;
        }
        if(count >= totalCount){
            return res;
        }
        if(count == totalCount-1 && path.size() == totalCount -1){
            for (int j = begin; j < nums.length; j++) {
                if(nums[j] == sum){
                    ArrayList subRes = new ArrayList<>(path);
                    subRes.add(sum);
                    if(!set.contains(subRes.toString())){
                        set.add(subRes.toString());
                        res.add(subRes);
                    }
                    break;
                }

            }
        }
        for (int i = begin; i < nums.length; i++) {
            // 不取当前位置
            if(nums.length -i >totalCount - count){
                List<List<Integer>> list2 = nSum(nums, count, sum,i+1, totalCount,path, res, set);
            }

            // 取当前位置的结果
            path.add(nums[i]);
            List<List<Integer>> list1 = nSum(nums,  count + 1, sum-nums[i],i+1, totalCount,path, res, set);
            // 还原现场
            path.remove(count);

        }

        return res;
    }
}
