package com.scn.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
 * @Date: 2021/1/19 22:09
 * @Description:
 */
public class Question46 {

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        getResult(nums,path,new HashSet<>(),res);
        return res;
    }

    private static void getResult(int[] nums, List<Integer> path, HashSet<Integer> set, List<List<Integer>> res) {
        if(set.size() == nums.length){

            res.add(new ArrayList<>(path));
            return;
        }
        for (int num : nums) {
            if(set.contains(num)){
                continue;
            }
            path.add(num);
            set.add(num);
            getResult(nums,path,set,res);
            path.remove((Object)num);
            set.remove((num));


        }
    }
}
