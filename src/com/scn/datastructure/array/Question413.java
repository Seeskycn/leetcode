package com.scn.datastructure.array;

import javax.lang.model.element.VariableElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-05-11
 */
public class Question413 {

    public static void main(String[] args) {
        numberOfArithmeticSlices(new int[]{1,3,5,7,9,0,10,11,12,13});
    }

    public static int numberOfArithmeticSlices(int[] nums) {


        List<List<Integer>> res = getRes(nums, 0);
        System.out.println(res);
        int count = 0;
        for (List<Integer> list : res) {
            Integer num = list.get(1) - list.get(0) + 1;
            if(num >3){

            }
        }
        return count;
    }

    private static List<List<Integer>> getRes(int[] nums, int begin) {
        List<List<Integer>> res = new ArrayList<>();
        int count = Integer.MAX_VALUE;
        int start = begin;
        for (int i = begin; i < nums.length; i++) {
            if (i + 1 < nums.length) {
                int num = nums[i + 1] - nums[i];
                if (count == Integer.MAX_VALUE) {
                    count = num;
                    continue;
                } else {
                    if (num != count) {
                        List<Integer> subRes = new ArrayList<>();
                        subRes.add(start);
                        subRes.add(i);
                        start = i;
                        res.add(subRes);
                        count = num;
                    }
                }
            } else {
                List<Integer> subRes = new ArrayList<>();
                subRes.add(start);
                subRes.add(i);
                res.add(subRes);
            }
        }

        return res;
    }
}
