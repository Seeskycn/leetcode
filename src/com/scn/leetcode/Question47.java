package com.scn.leetcode;

import java.util.*;

/*
 *-----------------神兽保佑 -----------------
 *           ┌─┐        ┌─┐
 *       ┌─┘  ┴────┘  ┴─┐
 *       │                        │
 *       │        ───          │
 *       │  ─┬┘       └┬─   │
 *       │                        │
 *       │       ─┴─           │
 *       │                        │
 *       └───┐          ┌──┘
 *               │          │
 *               │          │
 *               │          │
 *               │          └────────────┐
 *               │                                    │
 *               │                                    ├─┐
 *               │                                    ┌─┘
 *               │                                    │
 *               └─┐  ┐  ┌─────┬─┐  ┌──┘
 *                   │  ┤  ┤          │  ┤  ┤
 *                   └─┴─┘          └─┴─┘
 *
 * ------------------代码无BUG!--------------
 * @Author: Seesky
 * @Date: 2021/3/9 22:37
 * @Description:
 */
public class Question47 {

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1,1}));

    }

    public static List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        LinkedList<Integer> path = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        getResult(nums, res, path, set);

        return res;
    }

    private static void getResult(int[] nums, List<List<Integer>> res, LinkedList<Integer> path, Set<Integer> set) {

        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }


        for (int i = 0; i < nums.length; i++) {
            if (set.contains(i)) {
                continue;
            }
            set.add(i);
            path.addLast(nums[i]);
            getResult(nums, res, path, set);
            set.remove(i);
            path.removeLast();

            while (i + 1 < nums.length  && nums[i] == nums[i + 1]) {
                i = i + 1;
            }

        }
    }
}
