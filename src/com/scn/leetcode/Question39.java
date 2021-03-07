package com.scn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-01-17
 */
public class Question39 {

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,5}, 8));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        getResult(candidates,0, target, new LinkedList<>(), res);
        return res;
    }

    private static void getResult(int[] candidates,int begin,int target, LinkedList<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            //  注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            getResult(candidates,i,target - candidates[i], path, res);
            path.removeLast();

        }

    }

}
