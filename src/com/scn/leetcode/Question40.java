package com.scn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-01-17
 */
public class Question40 {

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        getResult(candidates, 0, new LinkedList<>(), target, res);
        return res;
    }

    private static void getResult(int[] candidates, int begin, LinkedList<Integer> path, int target, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = begin; i < candidates.length; i++) {

            path.addLast(candidates[i]);
            getResult(candidates, i + 1, path, target - candidates[i], res);
            path.removeLast();
            while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
                i = i + 1;
            }
        }

        return;
    }
}
