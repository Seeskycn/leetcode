package com.scn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-05-17
 */
public class Question491 {
    public static void main(String[] args) {
        List<List<Integer>> subsequences = findSubsequences(new int[]{4, 6, 7, 7});
        System.out.println(subsequences);
    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> res2 = new HashSet<>();
        LinkedList<Integer> path = new LinkedList<>();
        findSubsequences(nums, 0, res2, path);
        res.addAll(res2);
        return res;

    }

    private static void findSubsequences(int[] nums, int index, Set<List<Integer>> res, LinkedList<Integer> path) {
        for (int i = index; i < nums.length; i++) {
            if (path.size() == 0 || path.getLast() <=nums[i]) {
                path.addLast(nums[i]);
                if (path.size() >= 2) {
                    res.add(new ArrayList<>(path));
                }
                findSubsequences(nums, i+1, res, path);
                path.removeLast();
            }
        }
    }
}
